package com.cmx.controller;

import com.cmx.entity.Result;
import com.cmx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //查询所有文章
    @CrossOrigin
    @GetMapping("/findAllArticle")
    public Result findAllArticle(){
        try {
            return new Result(200,articleService.findAllArticle(),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //通过id查询文章
    @CrossOrigin
    @GetMapping("/findArticleById")
    public Result findArticleById(int article_id){
        try {
            return new Result(200,articleService.findArticleById(article_id),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }
}
