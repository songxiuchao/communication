package com.sandu.erp.dao;

import com.sandu.erp.vo.IpConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 11:47
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 11:47     xiaobing          v1.0.0           Created
 */
@Mapper
public interface IpConfigDao {

    /**
     * 将ip保存到数据库
     * @param ipConfig
     */
    void saveIp(IpConfig ipConfig);

    /**
     * 删除ip
     * @param id
     */
    void deleteIp(@Param("id") String id);

    /**
     * 通过ip查询详情
     * @param ip
     * @return
     */
    List<IpConfig> getByIp(@Param("ip") String ip);

    /**
     * 修该
     * @param ipConfig
     */
    void updateById(IpConfig ipConfig);
}
