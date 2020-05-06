package com.sandu.erp.service;

import com.sandu.erp.vo.IpConfig;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 11:45
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 11:45     xiaobing          v1.0.0           Created
 */
public interface IpConfigService {

    /**
     * 将ip保存到数据路
     * @param ipConfig
     */
    void saveIp(IpConfig ipConfig);

    /**
     * 删除ip
     * @param id
     */
    void deleteIp(String id);

    List<IpConfig> getByIp(String ip);

    /**
     * 修改
     * @param ipConfig
     */
    void updateById(IpConfig ipConfig);
}
