package com.cmx.service.impl;

import com.cmx.dao.UserDao;
import com.cmx.entity.User;
import com.cmx.service.UserService;
import com.cmx.util.QiniuImageUtil;
import com.cmx.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


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

    //用户注册
    public String register(User user) throws Exception {
        //判断当前用户名是否已经存在
        User userInDB=userDao.findUserByName(user.getUser_name());
        if(userInDB!=null){
            //用户名已存在,抛出提示信息
            throw new Exception("当前用户名已存在");
        }else{
            //注册用户
            //设置默认头像
            user.setUser_icon("default.png");
            userDao.addUser(user);
            return "注册成功";
        }
    }

    //修改用户头像地址
    public void updateIconById(String user_icon,int user_id){
        User user=new User();
        user.setUser_id(user_id);
        user.setUser_icon(user_icon);
        String oldUserIcon=userDao.findIconById(user_id);
        //更新头像
        userDao.updateIconById(user);
        System.out.println(oldUserIcon);
        if("default.png".equals(oldUserIcon)||"visiter.png".equals(oldUserIcon)){
            //不删除
            return;
        }else{
            //删除服务器中原先保存的头像
            QiniuImageUtil.deleteFileFromQiniu("userIcon/"+oldUserIcon);
        }
    }

}
