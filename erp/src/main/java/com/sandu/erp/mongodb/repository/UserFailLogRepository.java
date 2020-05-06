package com.sandu.erp.mongodb.repository;

import com.sandu.erp.vo.FailLogVo.FailLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Administrator
 */
@Repository
public interface UserFailLogRepository extends MongoRepository<FailLog, String> {

}