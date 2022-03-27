package com.cmx.dao;

import com.cmx.entity.Comment;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {

    //查询所有评论
    public List<Comment> findAllComment();

    //新增评论
    public void addComment(Comment comment);

    //查询评论总条数
    public int findCommentNum();

    //分页查询评论
    public Page<Comment> findCommentPage(String query);

    //通过评论id删除评论
    public void deleteCommentById(int comment_id);

}
