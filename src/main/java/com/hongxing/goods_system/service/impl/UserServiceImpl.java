package com.hongxing.goods_system.service.impl;

import com.hongxing.constant.IdentityType;
import com.hongxing.entity.UserAuthDO;
import com.hongxing.entity.UserBaseInfo;
import com.hongxing.exception.UserAuthException;
import com.hongxing.goods_system.mapper.UserAuthMapper;
import com.hongxing.goods_system.mapper.UserMapper;
import com.hongxing.goods_system.service.UserService;
import com.hongxing.security.PBKDF2;
import com.hongxing.utils.ValidatorUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
*
*/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserAuthMapper userAuthMapper;

    @Override
    public UserBaseInfo login(String text, String credential) throws UserAuthException {
        if (ValidatorUtil.isPhoneNumber(text)) {
            return authWithPwd(IdentityType.PHONE,text,credential);
        }
        if (ValidatorUtil.isUsername(text)){
            return authWithPwd(IdentityType.USERNAME,text,credential);
        }
        throw new UserAuthException("请输入手机号或用户名");
    }

    private UserBaseInfo authWithPwd(IdentityType identityType, String identifier, String password) throws UserAuthException {
        UserAuthDO userAuthDO = userAuthMapper.loginAuth(identityType.value(), identifier);
        if (userAuthDO == null) throw new UserAuthException("账号不存在");
        System.out.println("userAuthDO = " + userAuthDO);
        if (!PBKDF2.verify(password,userAuthDO.getSalt(),userAuthDO.getCredential())) {
            throw new UserAuthException("账号或密码错误");
        }
        return userMapper.selectById(userAuthDO.getUserId());
    }

}
