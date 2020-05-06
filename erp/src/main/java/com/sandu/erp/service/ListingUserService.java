package com.sandu.erp.service;

import com.alibaba.fastjson.JSONObject;
import com.sandu.erp.vo.ListingUserInfo;

public interface ListingUserService {
    /**
     * 获取新增的用户状态，房源信息
     * @return
     */
    JSONObject getListingInfo();

    /**
     * 根据用户id获取楼盘信息
     * @param userId
     * @return
     */
    ListingUserInfo getSalesSystemInfo(Long userId);
}
