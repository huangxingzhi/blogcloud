package com.user.controller;

import com.model.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户服务接口
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登陆授权，返回JWT
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        user.setToken(userService.login(user));
        return user;
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     */
    @RequestMapping(value = "/verifyToken")
    public boolean verifyToken(String token) {
        return userService.verifyToken(token);
    }
}