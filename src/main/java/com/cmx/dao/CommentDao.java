package com.cmx.dao;

import com.cmx.entity.Comment;
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

}
