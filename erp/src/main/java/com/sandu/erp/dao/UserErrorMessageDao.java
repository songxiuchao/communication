package com.sandu.erp.dao;

import com.sandu.erp.vo.UserErrorMessage.UserErrorMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserErrorMessageDao {
    /**
     * 保存用户错误信息
     * @param userErrorMessage
     */
    void saveInfo(UserErrorMessage userErrorMessage);

    /**
     * 查询发送失败的用户信息
     * @return
     */
    List<UserErrorMessage> getErrorUserMessageInfo();

    /**
     * 判断是否已经存在发送失败的消息
     * @param id
     * @return
     */
    UserErrorMessage getErrorMessageIsExist(@Param("id") Long id);

    /**
     * 更新失败次数
     */
    void updateErrorMessageNum(@Param("num") int num,@Param("id") long id);

    /**
     * 删除重新发送成功的失败信息
     * @param id
     */
    void deleteErrorMessage(@Param("id") Long id);
}
