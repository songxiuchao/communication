package com.sandu.erp.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sandu.erp.config.Properties;
import com.sandu.erp.dao.ListingUserDao;
import com.sandu.erp.service.ListingUserService;
import com.sandu.erp.util.DoPostJson;
import com.sandu.erp.util.SDUtil;
import com.sandu.erp.util.ValidateHelper;
import com.sandu.erp.vo.ChangeUserHouseInfo;
import com.sandu.erp.vo.ListingReturnUserInfo;
import com.sandu.erp.vo.ListingUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Service("listingUserService")
public class ListingUserServiceImpl implements ListingUserService {

    @Autowired
    private ListingUserDao listingUserDao;

    @Autowired
    private Properties properties;

    @Transactional
    @Override
    public JSONObject getListingInfo() {
        //查询多有未同步的客户
        List<ChangeUserHouseInfo> changeUserHouseInfoList = listingUserDao.getListingInfo();

        List<ChangeUserHouseInfo> changeList=new ArrayList<>();
        //更新查询出来的客户状态为已同步
        changeUserHouseInfoList.stream().filter(list->1 == list.getProcessState()).

                forEach(listingUserInfo -> {
                    if (!ValidateHelper.isEmpty(listingUserInfo))
                        listingUserDao.updateStatus(listingUserInfo.getId());
                    changeList.add(listingUserInfo);
                });

        JSONArray array= JSONArray.parseArray(JSON.toJSONString(changeList));
        SortedMap<Object,Object> parameters = new TreeMap<>();
        //获取时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStamp = dateFormat.format(System.currentTimeMillis());
        //需要加密的参数
        parameters.put("data",array);
        parameters.put("timestamp",timeStamp);
        parameters.put("operator_key",properties.getOperatorID());
        parameters.put("seq","0001");
        //加密
        String sign = SDUtil.Sign(parameters, properties.getOperatorSecret(), properties.getEncryption());
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("sign",sign);
        jsonObject.put("data",array);
        jsonObject.put("timestamp",timeStamp);
        jsonObject.put("operator_key",properties.getOperatorID());
        jsonObject.put("seq","0001");
        //创造传递的参数格式
        //JSONObject newResult=new JSONObject();
        //newResult.put("data",jsonObject);
        //发送请求
        String result = DoPostJson.doPostJson(properties.getPostUrl(), "data", jsonObject.toJSONString());

        JSONObject resultParameter = (JSONObject) JSONObject.parse(result);
        return resultParameter;
    }

    @Override
    public ListingUserInfo getSalesSystemInfo(Long userId) {
        //通过用户id查询楼盘id（如果用户有多个楼盘怎么办）
        String propertyId = listingUserDao.getPropertyId(userId);
        //通过楼盘id查询楼盘信息
        return listingUserDao.getSalesSystemInfo(propertyId);
    }
}
