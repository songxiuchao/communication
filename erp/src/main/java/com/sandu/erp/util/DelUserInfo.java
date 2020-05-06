package com.sandu.erp.util;

import com.sandu.erp.service.Impl.BaseSourceServiceImpl;
import com.sandu.erp.vo.JoinUserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DelUserInfo {


    public static void deleteUserInfo(Long id, List<JoinUserInfo> joinUserInfos,Long messageId){
        BaseSourceServiceImpl receiveService = (BaseSourceServiceImpl)ApplicationContextUtil.getBean("receiveService");
        receiveService.deleteUserInfo(id,joinUserInfos,messageId);
        log.info("删除信息成功");
    }
}
