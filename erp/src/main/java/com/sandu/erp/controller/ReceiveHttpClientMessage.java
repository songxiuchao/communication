package com.sandu.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.sandu.erp.constant.Result;
import com.sandu.erp.dao.ListingUserDao;
import com.sandu.erp.vo.ChangeUserHouseInfo;
import com.sandu.erp.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sxc
 * @version 1.0
 * @PACKAGE_NAME: com.sandu.erp.controller
 * @description: 这个是接受杨总数据库传过来的信息
 * @date 2020/5/6 16:06
 */
@RestController
@RequestMapping("/httpClient")
public class ReceiveHttpClientMessage {

    @Autowired
    private ListingUserDao listingUserDao;

    @GetMapping("/getMessage")
    public Result getMessage(HttpServletRequest request){
        String param = request.getParameter("param");
        List<ChangeUserHouseInfo> messageList = JSONArray.parseArray(param, ChangeUserHouseInfo.class);
        messageList.stream().forEach(list ->{
            listingUserDao.addMiddleInfo(list);
        });
        System.out.println(param);
        return Result.success("200");
    }
}
