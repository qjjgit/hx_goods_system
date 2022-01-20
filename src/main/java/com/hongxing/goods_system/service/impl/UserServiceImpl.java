package com.hongxing.goods_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongxing.goods_system.bean.User;
import com.hongxing.goods_system.mapper.UserMapper;
import com.hongxing.goods_system.service.UserService;
import com.hongxing.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
*/
@Service("userService")
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String text, String pwd) throws Exception {
        if (ValidatorUtil.isPhoneNumber(text)) {
            return authByPhoneAndPwd(text, pwd);
        }
        if (ValidatorUtil.isUsername(text)){
            return authByUsernameAndPwd(text, pwd);
        }
        throw new Exception("请输入手机号或用户名");
    }

    private User authByPhoneAndPwd(String phone, String pwd) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uphone",phone);// TODO: 2022/1/20 修改表结构
        queryWrapper.eq("upwd",pwd);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) throw new Exception("密码错误");
        return user;
    }

    private User authByUsernameAndPwd(String username, String pwd) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname",username);
        queryWrapper.eq("upwd",pwd);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) throw new Exception("密码错误");
        return user;
    }
}
