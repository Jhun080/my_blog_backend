package com.cmx.service.impl;

import com.cmx.dao.UserDao;
import com.cmx.entity.User;
import com.cmx.service.UserService;
import com.cmx.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //验证用户登录
    public User verifyUser(User user) {
        User userResult=userDao.findUserByNameAndPassword(user);
        if(userResult!=null){
            //登陆成功，生成token
            userResult.setUser_token(TokenUtil.createToken(userResult.getUser_name(),userResult.getPassword()));
            //更新数据库中的token
            userDao.updateUserTokenByName(userResult);
        }
        return userResult;
    }

    //通过token获取用户信息
    public User findUserByToken(String token){
        //验证token
        boolean flag=TokenUtil.verifyToken(token);
        if(flag){
            //token正确
            return userDao.findUserByToken(token);
        }
        //token错误
        return null;
    }

    //退出登录
    public void loginOut(User user,String token){
        //验证token
        boolean flag=TokenUtil.verifyToken(token);
        if(flag){
            //token正确,清除用户token
            userDao.cleanUserTokenByName(user);
        }
        //token错误
    }

}
