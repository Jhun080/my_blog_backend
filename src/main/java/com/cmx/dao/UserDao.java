package com.cmx.dao;

import com.cmx.entity.Article;
import com.cmx.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //通过用户名和密码查询用户
    public User findUserByNameAndPassword(User user);

    //通过用户名更新用户token
    public void updateUserTokenByName(User user);

    //通过token获取用户信息
    public User findUserByToken(String token);

    //通过用户名清除token
    public void cleanUserTokenByName(User user);

    //通过用户名查询用户
    public User findUserByName(String user_name);

    //添加用户
    public void addUser(User user);

    //通过ID查找用户基本信息
    public User findUserBaseById(String user_id);

    //通过token查询管理员权限
    public int findAuthorityByToken(String token);

    //查询用户头像地址
    public String findIconById(int user_id);

    //修改用户头像地址
    public void updateIconById(User user);
}
