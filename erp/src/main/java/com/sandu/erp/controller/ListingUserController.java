package com.sandu.erp.controller;


import com.alibaba.fastjson.JSONObject;
import com.sandu.erp.constant.ResponseCode;
import com.sandu.erp.constant.Result;
import com.sandu.erp.service.ListingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator (取更新的用户状态，房源信息测试类)
 * 这个是将咱这边客户，房源信息变更推给云客的测试类
 */
@RestController
@RequestMapping("/listing")
public class ListingUserController {

    @Autowired
    private ListingUserService listingUserService;

    @PostMapping("/getListingInfo")
    public Result getListingInfo(){
        return Result.success("查询成功",listingUserService.getListingInfo());
    }

    /**
     * 更新客户信息
     * @return
     */
    @PostMapping("/sendListingInfo")
    public Result sendListingInfo(){
        JSONObject listingInfo = listingUserService.getListingInfo();
        if (("success").equals(listingInfo.get("status"))){
            return Result.success("发送成功",listingInfo);
        }else {
            return Result.failure(ResponseCode.ERROR_DATA_VALIDATOR,listingInfo.getString("message"));
        }
    }

}
