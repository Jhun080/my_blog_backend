package com.cmx.service;

import com.cmx.entity.Article;

import java.util.List;

public interface ArticleService {
    //查询全部文章
    public List<Article> findAllArticle();

    //通过id查询文章
    public Article findArticleById(int article_id);
}
