package com.sandu.erp.service.Impl;

import com.sandu.erp.dao.UserDao;
import com.sandu.erp.service.UserService;
import com.sandu.erp.vo.UserInfo;
import com.sandu.erp.vo.UserInfoKh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 肖兵
 * @version v1.0.0
 * @date 2020/3/27 16:30
 * @Description Modification History:
 * Date                 Author          Version          Description
 * ---------------------------------------------------------------------------------*
 * 2020/3/27 16:30     xiaobing          v1.0.0           Created
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveMessage(UserInfoKh userInfoKh) {
        userDao.saveMessage(userInfoKh);
        userInfoKh.getJoinUserInfo().stream().forEach(list ->{
            userDao.addJoinMessage(list);
        });
    }

    @Override
    public List<UserInfo> getUserInfoList(String userName, String userPhone, Long consultantId) {
        return userDao.getUserInfoList(userName,userPhone,consultantId);
    }

    @Override
    public boolean getUserIdExist(Long userId) {
        return userDao.getUserIdExist(userId);
    }

    @Transactional
    @Override
    public void updateMessage(UserInfoKh userInfoKh) {
        //更新接收到的客户信息
        userDao.updateMessage(userInfoKh);

        //删除关联客户信息
        userDao.deleteJoinMessage(userInfoKh.getUserId());
        //更新当前客户的关联客户
        userInfoKh.getJoinUserInfo().stream().forEach(list ->{
            userDao.addJoinMessage(list);
        });

    }
}
