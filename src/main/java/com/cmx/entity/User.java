package com.cmx.entity;

/**
 * 用户表
 * userid:      用户ID
 * user_name:   用户名
 * password:    密码
 * user_icon:   用户头像地址
 * user_token:  用户token
 */
public class User {
    private Integer user_id;
    private String user_name;
    private String password;
    private String user_icon;
    private String user_token;

    public User(Integer user_id, String user_name, String password, String user_icon, String user_token) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.user_icon = user_icon;
        this.user_token = user_token;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", user_icon='" + user_icon + '\'' +
                ", user_token='" + user_token + '\'' +
                '}';
    }

    public User() {
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }
}
