package com.hongxing.goods_system.controller;

import com.hongxing.goods_system.bean.ResultData;
import com.hongxing.goods_system.bean.User;
import com.hongxing.goods_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/auth/login")
    public String login(String auth,String password){
        try {
            User user = userService.login(auth, password);
            return new ResultData(user).toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultData(e.getMessage(),null).toJSONString();
        }
    }
}
