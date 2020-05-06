package com.sandu.erp.dao;

import com.sandu.erp.vo.JoinUserInfo;
import com.sandu.erp.vo.UserInfo;
import com.sandu.erp.vo.UserPropertyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiveDao {
    /**
     * 存储新增的客户信息
     * @param list
     */
    void saveReceiveInfo(UserInfo list);

    /**
     * 存储用户对应的楼盘
     * @param userPropertyVo
     */
    void savePropertyInfo(UserPropertyVo userPropertyVo);

    /**
     * 判断用户是否已经存在
     * @param userId
     * @return
     */
    boolean userIsExist(@Param("userId") Long userId);

    /**
     * 更新客户信息
     * @param userInfo
     */
    void updateReceiveInfo(UserInfo userInfo);

    /**
     * 保存关联客户
     * @param joinUserInfo
     */
    void saveJoinUserInfo(JoinUserInfo joinUserInfo);


    /**
     * 判断该楼盘下用户存不存在
     * @param userId
     * @return
     */
    Integer userIsExistInHouse(@Param("userId") Long userId,@Param("propertyId") String propertyId);

    /**
     * 更新关联客户
     * @param joinUserInfo
     */
    void updateJoinUserInfo(JoinUserInfo joinUserInfo);


    /**
     * 删除该userId对应的关联客户
     * @param userId
     */
    void deleteJoinUserInfo(@Param("userId") Long userId);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUserInfo(@Param("id") Long id);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteJoinUserInfoById(Long id);

    /**
     * 删除userproperty表信息
     * @param messageId
     */
    void deleteUserpropertyInfo(Long messageId);
}
