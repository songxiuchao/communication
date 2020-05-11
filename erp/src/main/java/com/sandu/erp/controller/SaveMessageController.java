package com.sandu.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sandu.erp.constant.Result;
import com.sandu.erp.service.UserService;
import com.sandu.erp.vo.JoinUserInfo;
import com.sandu.erp.vo.UserInfo;
import com.sandu.erp.vo.UserInfoKh;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 15:13
 * @Description Modification History: 这个是存储用户信息的测试类
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 15:13     xiaobing          v1.0.0           Created
 */
@RestController
@RequestMapping("/userMessage")
@Slf4j
public class SaveMessageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public Result saveMessage(UserInfoKh userInfoKh){
        List<JoinUserInfo> joinUserInfos = JSONArray.parseArray(userInfoKh.getNewJoinUserInfo(), JoinUserInfo.class);
        userInfoKh.setJoinUserInfo(joinUserInfos);
        log.info("进入第三步骤,接受的消息："+userInfoKh);
        JSONObject data=new JSONObject();
        try {
            if (userService.getUserIdExist(userInfoKh.getUserId())){
                log.info("用户"+userInfoKh.getUserName()+"已经录入，开始更新操作");
                userService.updateMessage(userInfoKh);
                data.put("data",1);
                data.put("userErrormessageId",userInfoKh.getUserErrormessageId());
                return Result.success("更新成功",data);
            }
            userService.saveMessage(userInfoKh);
            log.info("第三步骤成功");
        }catch (Exception e){
            log.info("信息接收失败，发生异常，开始回滚");
            data.put("data",0);
            data.put("userInfoId",userInfoKh.getUserInfoId());
            data.put("joinUserInfo",userInfoKh.getJoinUserInfo());
            data.put("userPropertyId",userInfoKh.getUserPropertyId());
            return Result.success("异常",data);
        }
            data.put("data",1);
            data.put("userErrormessageId",userInfoKh.getUserErrormessageId());
        return Result.success("保存成功",data);
    }



    @GetMapping("/getList")
    public List<UserInfo> getUserInfoList(@RequestParam(required = false) String userName,
                                          @RequestParam(required = false) String userPhone,
                                          @RequestParam(required = false) Long consultantId){
      return userService.getUserInfoList(userName,userPhone,consultantId);
    }


}
