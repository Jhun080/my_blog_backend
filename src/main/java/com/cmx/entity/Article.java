package com.cmx.entity;

import java.util.Date;

public class Article {
    private int id;//文章id
    private String article_title;//文章标题
    private int article_like;//点赞数
    private int article_comment;//评论数
    private int article_view;//浏览数
    private Date article_createtime;//创建日期
    private String article_url;//文章url地址

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", article_title='" + article_title + '\'' +
                ", article_like=" + article_like +
                ", article_comment=" + article_comment +
                ", article_view=" + article_view +
                ", article_createtime=" + article_createtime +
                ", article_url='" + article_url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public int getArticle_like() {
        return article_like;
    }

    public void setArticle_like(int article_like) {
        this.article_like = article_like;
    }

    public int getArticle_comment() {
        return article_comment;
    }

    public void setArticle_comment(int article_comment) {
        this.article_comment = article_comment;
    }

    public int getArticle_view() {
        return article_view;
    }

    public void setArticle_view(int article_view) {
        this.article_view = article_view;
    }

    public Date getArticle_createtime() {
        return article_createtime;
    }

    public void setArticle_createtime(Date article_createtime) {
        this.article_createtime = article_createtime;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public Article() {
    }
}
