package com.sandu.erp.dao;

import com.sandu.erp.vo.JoinUserInfo;
import com.sandu.erp.vo.UserInfo;
import com.sandu.erp.vo.UserInfoKh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 16:31
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 16:31     xiaobing          v1.0.0           Created
 */
@Mapper
public interface UserDao {
    /**
     * 将客户信息保存下来
     * @param userInfoKh
     */
    void saveMessage(UserInfoKh userInfoKh);

    /**
     * 获得用户列表
     * @param userName
     * @param userPhone
     * @param consultantId
     * @return
     */
    List<UserInfo> getUserInfoList(@Param("userName") String userName,
                                   @Param("userPhone") String userPhone,@Param("consultantId") Long consultantId);

    /**
     * 判断用户是否录入
     * @param userId
     * @return
     */
    boolean getUserIdExist(@Param("userId") Long userId);

    /**
     * 更新用户
     * @param userInfoKh
     */
    void updateMessage(UserInfoKh userInfoKh);

    /**
     * 删除关联客户信息
     * @param userId
     */
    void deleteJoinMessage(@Param("userId") Long userId);

    /**
     * 新增关联客户信息
     * @param list
     */
    void addJoinMessage(JoinUserInfo list);
}
