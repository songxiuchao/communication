package com.sandu.erp.contract;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sandu.common.exception.BaseParamException;
import com.sandu.common.exception.GlobalExceptionCode;
import com.sandu.common.response.ResultCode;
import com.sandu.common.response.ReturnValueLoader;
import com.sandu.erp.contract.pojo.po.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户 接口实现类
 * Module: UserServiceImpl.java
 *
 * @author xiaobing
 * @since JDK 1.8
 * @version 1.1
 * @date 2020-03-02
 * @Descriptions:
*/
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 功能描述: 新增用户
     *
     * @param:
     * @auther: xiaobing
     * @date: 2020-03-02
     * @return:
    */
    @Override
    @Transactional
    public Long put(User saveDto) {

        //如果需要保存的数据为空，则直接抛错
        if (saveDto == null) {
        throw new BaseParamException("参数不合法", GlobalExceptionCode.NOT_FOUND_EXCEPTION_CODE);

        }
        //新建空白指向
        User user;
        //如果有ID 为修改，查询要修改的对象
        if (saveDto.getId() != null && saveDto.getId() != 0L) {
            user = this.userMapper.selectById(saveDto.getId());

            //查询不到抛出错误
            if (user == null) {
             throw new BaseParamException("主键ID不存在", GlobalExceptionCode.NOT_FOUND_EXCEPTION_CODE);
            }
        } else {
        //无ID 为新增
        //新建对象
        user = new User();
        //初始化对象
        saveDto.setId(null);
        }
        //设置必改项
        BeanUtils.copyProperties(saveDto, user);
        //修改或新增
          if (saveDto.getId() != null && saveDto.getId() != 0L) {

              this.userMapper.updateById(user);
            return user.getId();
          } else {
            this.userMapper.insert(user);
            return user.getId();
          }
    }





     /**
      * 功能描述: 查看用户详情
      *
      * @param:
      * @auther: xiaobing
      * @date: 2020-03-02
      * @return:
     */
     @Override
     public User detail(Long id) {
         User user = this.userMapper.selectById(id);
         //判断实体是否有数据
         if (user == null) {
         }
         //创建结算单位返回实体
         User detailsVO = new User();
         BeanUtils.copyProperties(user, detailsVO);
         return detailsVO;
     }




        /**
        *
        * 功能描述: 新增用户提交
        *
        * @param:
        * @auther: xiaobing
        * @date: 2020-03-02
        * @return:
        */
        @Override
        @Transactional
        public int submit(User saveDto) {

        //先走一遍保存或修改方法
         Long id = this.put(saveDto);
        //查出实体对象
        User user = this.userMapper.selectById(id);

        //提交动作直接状态为待审核(state=1)
        /*
        todo 需要根据业务改变
        */

        return 1;
        }



        /**
        *
        * 功能描述: 移除一条用户信息
        *
        * @param:
        * @auther: xiaobing
        * @date: 2020-03-02
        * @return:
        */
        @Override
        @Transactional
        public int delete(Long id) {

        //根据当前ID查询实体
        User user = this.userMapper.selectById(id);

        //判断查询的信息是否为空.如果为空,返回提示信息
        if(user == null){
        throw new BaseParamException("数据不合法", GlobalExceptionCode.METHOD_ARGUMENT_EXCEPTION_CODE);
        }
        //查询的状态进行判断,如果该数据是提交的数据的话,提示该数据不允许次操作
        /*
        todo 需要根据业务改变
        */

        //判断如果有联系,那么不能删除,返回相应提示信息
        /*
        todo 需要根据业务改变
        */
        //if (!canDelete) {
        //       }
        //执行删除
        int deleteCount = this.userMapper.deleteById(id);
        return deleteCount;
        }


    }