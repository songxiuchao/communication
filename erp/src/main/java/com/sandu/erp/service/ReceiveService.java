package com.sandu.erp.service;

import com.sandu.erp.vo.JoinUserInfo;
import com.sandu.erp.vo.ReceiveInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ReceiveService {
    /**
     * 将新增的客户信息保存到数据库
     * @param messageList
     */
    void saveReceiveInfo(List<ReceiveInfo> messageList) throws Exception;

    /**
     * 删除用户信息
     * @param userId
     */
    void deleteUserInfo(Long userId,List<JoinUserInfo> joinUserInfos,Long messageId);
}
