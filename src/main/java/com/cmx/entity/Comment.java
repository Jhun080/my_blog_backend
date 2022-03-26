package com.cmx.entity;

import java.util.Date;

/**
 * 用户评论实体类
 * comment_id               评论ID
 * user_id          评论者ID
 * comment_time     评论时间
 * comment_source   评论来源
 * comment_text     评论内容
 * user             用户
 */
public class Comment {
    private int comment_id;
    private int user_id;
    private Date comment_time;
    private String comment_source;
    private String comment_text;
    private User user;

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", user_id=" + user_id +
                ", comment_time=" + comment_time +
                ", comment_source='" + comment_source + '\'' +
                ", comment_text='" + comment_text + '\'' +
                ", user=" + user +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_source() {
        return comment_source;
    }

    public void setComment_source(String comment_source) {
        this.comment_source = comment_source;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment(int comment_id, int user_id, Date comment_time, String comment_source, String comment_text, User user) {
        this.comment_id = comment_id;
        this.user_id = user_id;
        this.comment_time = comment_time;
        this.comment_source = comment_source;
        this.comment_text = comment_text;
        this.user = user;
    }

    public Comment() {
    }
}
