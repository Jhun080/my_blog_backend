package com.cmx.controller;

import com.cmx.entity.Comment;
import com.cmx.entity.Result;
import com.cmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    //查询全部评论
    @CrossOrigin
    @GetMapping("/findAllComment")
    public Result findAllComment(){
        try {
            return new Result(200,commentService.findAllComment(),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //新增评论
    @CrossOrigin
    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment, HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            commentService.addComment(token,comment);
            return new Result(200,null,"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //查询评论总条数
    @CrossOrigin
    @GetMapping("/findCommentNum")
    public Result findCommentNum(){
        try {
            return new Result(200,commentService.findCommentNum(),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }


}
