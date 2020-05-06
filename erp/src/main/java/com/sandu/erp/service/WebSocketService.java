package com.sandu.erp.service;

import com.sandu.erp.vo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 13:38
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 13:38     xiaobing          v1.0.0           Created
 */
public interface WebSocketService {

    Message getUserInfo( String propertyId);
}
