package com.sandu.erp.contract;

import com.sandu.common.response.ReturnValueLoader;
import com.sandu.erp.contract.pojo.po.User;


/**
 * 用户 接口层
 * Module: UserService.java
 *
 * @author xiaobing
 * @since JDK 1.8
 * @version 1.1
 * @date 2020-03-02
 * @Descriptions:
*/
public interface UserService  {

    /**
     *
     * 功能描述: 新增用户
     *
     * @param: saveDto 新增需要的参数
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    Long put(User saveDto);


    /**
     *
     * 功能描述: 查看用户详情
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    User detail(Long id);

    /**
     *
     * 功能描述: 获取用户列表
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */


    /**
     *
     * 功能描述: 新增用户提交
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    int submit(User saveDto);


    /**
     *
     * 功能描述: 移除一条用户信息
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
     */
    int delete(Long id);
    }