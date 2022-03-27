package com.cmx.service;

import com.cmx.entity.Comment;
import com.cmx.entity.PageResult;
import com.cmx.entity.QueryPage;

import java.util.List;
import java.util.Map;

public interface CommentService {
    //查询所有评论
    public List<Comment> findAllComment();

    //新增评论
    public void addComment(String token,Comment comment);

    //查询评论总条数
    public int findCommentNum();

    //分页查询评论
    public PageResult findCommentPage(QueryPage queryPage);

    //删除评论
    public Map<String,String> deleteComment(String token, int comment_id);

}
