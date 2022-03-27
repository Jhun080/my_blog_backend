package com.cmx.controller;

import com.cmx.entity.Comment;
import com.cmx.entity.PageResult;
import com.cmx.entity.QueryPage;
import com.cmx.entity.Result;
import com.cmx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    //分页查询评论
    @CrossOrigin
    @PostMapping("/findCommentPage")
    public Result findCommentPage(@RequestBody QueryPage queryPage){
        try {
            PageResult commentPage = commentService.findCommentPage(queryPage);
            return new Result(200,commentPage,"成功",true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,null,"失败",false);
        }
    }

    //删除评论
    @CrossOrigin
    @GetMapping("/deleteComment")
    public Result deleteComment(int commentId,HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            Map<String, String> result = commentService.deleteComment(token, commentId);
            return new Result(Integer.parseInt(result.get("code")),null,result.get("message"),true);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(500,null,"删除失败",false);
        }
    }


}
