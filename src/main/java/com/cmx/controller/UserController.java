package com.cmx.controller;

import com.cmx.entity.Result;
import com.cmx.entity.User;
import com.cmx.service.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    //验证用户登录
    @CrossOrigin
    @PostMapping("/verifyUser")
    public Result verifyUser(@RequestBody User user){
        try {
            return new Result(200,userService.verifyUser(user),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //通过token获取用户信息
    @CrossOrigin
    @PostMapping("/getUserInfo")
    public Result getUserInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        try {
            return new Result(200,userService.findUserByToken(token),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //退出登录
    @CrossOrigin
    @PostMapping("/logout")
    public Result logout(@RequestBody User user,HttpServletRequest request){
        String token = request.getHeader("token");
        try {
            //退出登陆
            userService.loginOut(user,token);
            return new Result(200,null,"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //注册用户
    @CrossOrigin
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        try {
            //注册用户
            String message = userService.register(user);
            return new Result(200,null,message,true);
        }catch (Exception e){
            return new Result(500,null,"当前用户名已存在",false);
        }
    }

}
