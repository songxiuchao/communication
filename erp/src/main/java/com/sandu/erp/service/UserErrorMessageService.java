package com.sandu.erp.service;

import com.sandu.erp.vo.UserErrorMessage.UserErrorMessage;

import java.util.List;

public interface UserErrorMessageService {
    /**
     * 保存用户错误信息
     * @param userErrorMessage
     */
    void saveInfo(UserErrorMessage userErrorMessage);

    /**
     * 查询未发送的用户信息
     * @return
     */
    List<UserErrorMessage> getErrorUserMessageInfo();

    /**
     * 判断是否已经存在发送失败的消息
     * @param id
     * @return
     */
    UserErrorMessage getErrorMessageIsExist(Long id);

    /**
     * 更新失败次数
     */
    void updateErrorMessageNum(int num,long id);

    /**
     * 删除重新发送成功的失败信息
     * @param id
     */
    void deleteErrorMessage(Long id);
}
