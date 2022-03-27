package com.cmx.service.impl;

import com.cmx.dao.CommentDao;
import com.cmx.dao.UserDao;
import com.cmx.entity.*;
import com.cmx.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //分页查询评论
    public PageResult findCommentPage(QueryPage queryPage){
        //当前页码
        Integer currentPage = queryPage.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPage.getPageSize();
        //查询条件
        String query = queryPage.getQuery();
        //完成分页查询，基于Mybatis提供的分页助手插件
        PageHelper.startPage(currentPage,pageSize);
        Page<Comment> page = commentDao.findCommentPage(query);
        List<Comment> rows = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,rows);
    }

    //删除评论
    public Map<String,String> deleteComment(String token, int comment_id){
        Map<String,String> result=new HashMap<>();
        //查询token
        if(token==null){
            //说明是以游客的身份评论，禁止
            result.put("code","500");
            result.put("message","没有权限");
        }else{
            //用户已登录，查询权限
            int authority = userDao.findAuthorityByToken(token);
            if(authority==1){
                //管理员权限
                //删除评论
                commentDao.deleteCommentById(comment_id);
                result.put("code","200");
                result.put("message","删除成功");
            }else{
                //普通用户
                result.put("code","500");
                result.put("message","没有权限");
            }
        }
        return result;
    }

}
