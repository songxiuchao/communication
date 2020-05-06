package com.sandu.erp.dao;

import com.sandu.erp.vo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 13:40
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 13:40     xiaobing          v1.0.0           Created
 */
@Mapper
public interface WebSocketDao {


    /**
     * 获取用户信息
     * @return
     */
    Message getUserInfo(@Param("propertyId") String propertyId);

}
