package com.sandu.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.sandu.erp.service.UserErrorMessageService;
import com.sandu.erp.util.DelUserInfo;
import com.sandu.erp.vo.JoinUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 与前端交接发生错误回滚的类
 */

@RestController
@RequestMapping("/error")
@Slf4j
public class ErrorController {

    @Autowired
    private UserErrorMessageService userErrorMessageService;

    @RequestMapping("/errorMessage")
    public void  getErrorMessage(@RequestParam int result, @RequestParam Long userInfoId,
             @RequestParam String joinUserInfo, @RequestParam Long userPropertyId) throws Exception {
        log.info("服务端接收到错误日志:   "+result);
        if (result == 0){
            log.info("服务端正在删除新增信息");
            List<JoinUserInfo> joinUserInfos = JSONArray.parseArray(joinUserInfo, JoinUserInfo.class);
            DelUserInfo.deleteUserInfo(userInfoId,joinUserInfos,userPropertyId);
        }else {
            log.info("信息接收成功");
        }
    }

    /**
     * 删除重新发送成功的失败信息
     * @param userErrormessageId
     */
    @RequestMapping("/deleteErrorMessage")
    public void deleteErrorMessage(@RequestParam Long userErrormessageId){
        userErrorMessageService.deleteErrorMessage(userErrormessageId);
    }

}
