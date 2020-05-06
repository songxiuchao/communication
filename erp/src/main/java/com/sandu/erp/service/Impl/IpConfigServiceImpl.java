package com.sandu.erp.service.Impl;

import com.sandu.erp.dao.IpConfigDao;
import com.sandu.erp.service.IpConfigService;
import com.sandu.erp.vo.IpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class IpConfigServiceImpl implements IpConfigService {

    @Autowired
    private IpConfigDao ipConfigDao;

    @Transactional
    @Override
    public void saveIp(IpConfig ipConfig) {
        ipConfigDao.saveIp(ipConfig);
    }

    @Transactional
    @Override
    public void deleteIp(String id) {
        ipConfigDao.deleteIp(id);
    }

    @Override
    public List<IpConfig> getByIp(String ip) {
        return ipConfigDao.getByIp(ip);
    }

    @Transactional
    @Override
    public void updateById(IpConfig ipConfig) {
        ipConfigDao.updateById(ipConfig);
    }
}
