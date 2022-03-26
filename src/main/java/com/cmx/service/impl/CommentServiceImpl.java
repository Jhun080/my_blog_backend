package com.cmx.service.impl;

import com.cmx.dao.CommentDao;
import com.cmx.dao.UserDao;
import com.cmx.entity.Comment;
import com.cmx.entity.User;
import com.cmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;

    //查询所有评论
    public List<Comment> findAllComment(){
        return commentDao.findAllComment();
    }

    //新增评论
    public void addComment(String token,Comment comment){
        //查询token
        if(token==null){
            //说明是以游客的身份评论,游客的user_id为 0
            comment.setUser_id(0);
        }else{
            User user=userDao.findUserByToken(token);
            if(user==null){
                //说明token过期，以游客的身份评论,游客的user_id为 0
                comment.setUser_id(0);
            }else{
                //若用户登录，则赋值为用户的user_id
                comment.setUser_id(user.getUser_id());
            }
        }
        //新增评论
        commentDao.addComment(comment);
    }

    //查询评论总条数
    public int findCommentNum(){
        return commentDao.findCommentNum();
    }

}
