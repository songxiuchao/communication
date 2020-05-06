package com.sandu.erp.service.Impl;

import com.sandu.erp.dao.WebSocketDao;
import com.sandu.erp.service.WebSocketService;
import com.sandu.erp.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/25 13:40
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/25 13:40     xiaobing          v1.0.0           Created
 */
@Service("webSocketService")
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private WebSocketDao webSocketDao;

    @Override
    public Message getUserInfo(String propertyId) {
        return webSocketDao.getUserInfo(propertyId);
    }
}
