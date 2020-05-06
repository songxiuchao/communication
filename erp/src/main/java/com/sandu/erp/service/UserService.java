package com.sandu.erp.service;

import com.sandu.erp.vo.UserInfo;
import com.sandu.erp.vo.UserInfoKh;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 16:30
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 16:30     xiaobing          v1.0.0           Created
 */
public interface UserService {

    /**
     * 将客户信息保存下来
     * @param userInfo
     */
    void saveMessage(UserInfoKh userInfo);

    /**
     * 获得用户列表
     * @param userName
     * @param userPhone
     * @param consultantId
     * @return
     */
    List<UserInfo> getUserInfoList(String userName, String userPhone, Long consultantId);

    /**
     * 判断用户是否录入
     * @param userId
     * @return
     */
    boolean getUserIdExist(Long userId);

    /**
     * 更新用户
     * @param userInfoKh
     */
    void updateMessage(UserInfoKh userInfoKh);
}
