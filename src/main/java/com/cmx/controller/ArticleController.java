package com.cmx.controller;

import com.cmx.entity.Article;
import com.cmx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //查询所有文章
    @CrossOrigin
    @GetMapping("/findAllArticle")
    public List<Article> findAllArticle(){
        return articleService.findAllArticle();
    }
}
