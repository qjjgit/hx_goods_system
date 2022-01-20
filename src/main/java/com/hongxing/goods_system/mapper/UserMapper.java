package com.hongxing.goods_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongxing.goods_system.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    User authByPhoneAndPwd();
//    User authByUsernameAndPwd();
}
