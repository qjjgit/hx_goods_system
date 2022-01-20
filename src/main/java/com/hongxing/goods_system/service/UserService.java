package com.hongxing.goods_system.service;

import com.hongxing.goods_system.bean.User;

public interface UserService {
    User login(String text,String pwd) throws Exception;
}
