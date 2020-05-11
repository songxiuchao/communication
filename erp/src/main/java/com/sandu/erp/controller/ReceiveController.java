package com.sandu.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.sandu.erp.constant.Result;
import com.sandu.erp.service.ReceiveService;
import com.sandu.erp.vo.ReceiveInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.List;

/**
 * 这个是接受云客传过来的用户信息测试类
 */
@Controller
@RequestMapping("/receive")
@Slf4j
public class ReceiveController {

    @Autowired
    private ReceiveService receiveService;

    @ResponseBody
    @RequestMapping("/receiveParameter")
    @Transactional
    public Result receiveParameter(String receiveInfo) throws Exception {
        String decode = URLDecoder.decode(receiveInfo, "UTF-8");
        //json字符串直接转为List<java>对象
        List<ReceiveInfo> messageList = JSONArray.parseArray(decode, ReceiveInfo.class);
        //将新增的客户信息保存到数据库
        receiveService.saveReceiveInfo(messageList);
        return Result.success("请求成功","ok");
    }

}
