package com.sandu.erp.service.Impl;

import com.sandu.erp.dao.UserErrorMessageDao;
import com.sandu.erp.service.UserErrorMessageService;
import com.sandu.erp.vo.UserErrorMessage.UserErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userErrorMessageService")
public class UserErrorMessageServiceImpl implements UserErrorMessageService {

    @Autowired
    private UserErrorMessageDao userErrorMessageDao;

    @Override
    public void saveInfo(UserErrorMessage userErrorMessage) {
        userErrorMessageDao.saveInfo(userErrorMessage);
    }

    @Override
    public List<UserErrorMessage> getErrorUserMessageInfo() {
       return userErrorMessageDao.getErrorUserMessageInfo();
    }

    @Override
    public UserErrorMessage getErrorMessageIsExist(Long id) {
        return userErrorMessageDao.getErrorMessageIsExist(id);
    }

    @Override
    public void updateErrorMessageNum(int num,long id) {
        userErrorMessageDao.updateErrorMessageNum(num,id);
    }

    @Override
    public void deleteErrorMessage(Long id) {
        userErrorMessageDao.deleteErrorMessage(id);
    }
}
