package com.sandu.erp.mongodb.config;

import com.sandu.erp.mongodb.exception.SaveLogException;
import com.sandu.erp.mongodb.repository.UserFailLogRepository;
import com.sandu.erp.vo.FailLogVo.FailLog;
import com.sandu.erp.vo.UserInfoKh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @program: demo
 * @description: 日志操作类
 * @author: xiuchao Song
 * @create: 2019-11-04 16:17
 **/
@Component("logAssistant")
public class LogAssistant {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserFailLogRepository userFailLogRepository;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /**
     * 保存订单日志
     */
    @Async
    public void saveFailLog(FailLog log) throws SaveLogException {
        userFailLogRepository.save(log);
    }

    /**
     * 查看订单日志
     * @param userId userId
     */
    public List<FailLog> getFailLog(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userKey").is(userId));
        query.with(Sort.by(Sort.Order.asc("time")));
        return mongoTemplate.find(query, FailLog.class);
    }

}
