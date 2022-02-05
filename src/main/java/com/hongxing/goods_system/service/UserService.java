package com.hongxing.goods_system.service;

import com.hongxing.entity.UserBaseInfo;

public interface UserService {
    UserBaseInfo login(String text, String credential) throws Exception;
}
