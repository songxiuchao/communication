package com.sandu.erp.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sandu.erp.config.Properties;
import com.sandu.erp.config.WebSocketServer;
import com.sandu.erp.dao.ReceiveDao;
import com.sandu.erp.service.ReceiveService;
import com.sandu.erp.util.ValidateHelper;
import com.sandu.erp.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询供应商相关信息
 *
 * @author Administrator
 */
@Slf4j
@Service("receiveService")
public class BaseSourceServiceImpl implements ReceiveService {

    @Autowired
    private ReceiveDao receiveDao;

    @Autowired
    private Properties properties;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveReceiveInfo(List<ReceiveInfo> messageList) throws Exception {
        List<Message> listMessage=new ArrayList<>();
        messageList.stream().forEach(list->{
            UserPropertyVo userPropertyVo = new UserPropertyVo();
            UserInfo userInfo = list.getUserInfo();
            //判断该楼盘下用户存不存在(是否是新增的用户)
            if (receiveDao.userIsExistInHouse(list.getUserInfo().getUserId(),list.getPropertyId())>0){
                //存在:更新客户信息
                if (!ValidateHelper.isEmpty(userInfo)){
                    //更新客户信息
                    receiveDao.updateReceiveInfo(userInfo);
                    //更新关联客户信息=======
                    //方便起见先删后插===
                    //删除该userId对应的关联客户
                    receiveDao.deleteJoinUserInfo(userInfo.getUserId());
                    userInfo.getJoinUserInfo().stream().forEach(joinUserInfo -> {
                        joinUserInfo.setUserId(userInfo.getUserId());
                        //保存关联客户信息
                        receiveDao.saveJoinUserInfo(joinUserInfo);
                    });
                }
            }else {
                //将接收到的新增客户保存到数据库
                if (!ValidateHelper.isEmpty(userInfo)){
                    receiveDao.saveReceiveInfo(userInfo);
                    userInfo.getJoinUserInfo().stream().forEach(joinUserInfo -> {
                        //表示该关联客户还关联着当前的userId
                        joinUserInfo.setUserId(userInfo.getUserId());
                        receiveDao.saveJoinUserInfo(joinUserInfo);
                    });

                }
                userPropertyVo.setPropertyId(list.getPropertyId());
                userPropertyVo.setUserId(userInfo.getUserId());
                receiveDao.savePropertyInfo(userPropertyVo);
            }
            //拼装发送给楼盘公司的数据
            Message message = new Message();
            message.setPropertyId(list.getPropertyId());
            message.setUserInfo(userInfo);
            message.setUserPropertyId(userPropertyVo.getId());
            message.setUserInfoId(userInfo.getId());
            listMessage.add(message);
        });
        log.info("第一部成功");
        //将各个楼盘对应客户分发给各个公司管理的楼盘
        WebSocketServer webSocketServer=new WebSocketServer();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(listMessage));
        webSocketServer.sendToUser(array.toJSONString(),properties.getMyIp());
    }

    @Transactional
    @Override
    public void deleteUserInfo(Long id,List<JoinUserInfo> joinUserInfos,Long messageId) {
        //删除userinfo表信息
        receiveDao.deleteUserInfo(id);
        //删除joinuserinfo用户信息
        joinUserInfos.stream().forEach(list ->{
            receiveDao.deleteJoinUserInfoById(list.getId());
        });
        //删除userproperty表信息
        receiveDao.deleteUserpropertyInfo(messageId);
    }

}
