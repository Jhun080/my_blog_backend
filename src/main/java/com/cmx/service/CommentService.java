package com.cmx.service;

import com.cmx.entity.Comment;

import java.util.List;

public interface CommentService {
    //查询所有评论
    public List<Comment> findAllComment();

    //新增评论
    public void addComment(String token,Comment comment);

    //查询评论总条数
    public int findCommentNum();


}
