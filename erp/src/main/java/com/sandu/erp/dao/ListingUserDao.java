package com.sandu.erp.dao;

import com.sandu.erp.vo.ChangeUserHouseInfo;
import com.sandu.erp.vo.ListingReturnUserInfo;
import com.sandu.erp.vo.ListingUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ListingUserDao {

    /**
     * 获取新增的用户状态，房源信息
     * @return
     */
    List<ChangeUserHouseInfo> getListingInfo();

    /**
     * 更新同步状态
     * @param id
     */
    void updateStatus(@Param("id") Long id);

    /**
     * 通过楼盘id查询楼盘信息
     * @param propertyId
     * @return
     */
    ListingUserInfo getSalesSystemInfo(@Param("propertyId") String propertyId );

    /**
     * 通过用户id查询楼盘id
     * @param userId
     * @return
     */
    String getPropertyId(@Param("userId") Long userId);
}
