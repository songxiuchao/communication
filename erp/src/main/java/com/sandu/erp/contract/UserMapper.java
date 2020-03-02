package com.sandu.erp.contract;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sandu.erp.contract.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author xiaobing
 * @since 2020-03-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
