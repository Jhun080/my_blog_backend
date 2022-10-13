package com.cmx.service;

import com.cmx.entity.User;

import java.util.List;

public interface UserService {
    //验证用户登录
    public User verifyUser(User user);

    //通过token获取用户信息
    public User findUserByToken(String token);

    //退出登录
    public void loginOut(User user,String token);

    //用户注册
    public String register(User user) throws Exception;

    //修改用户头像地址
    public void updateIconById(String user_icon,int user_id);
}
