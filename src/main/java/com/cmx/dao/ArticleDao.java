package com.cmx.dao;

import com.cmx.entity.Article;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {

    //查询全部文章
    public List<Article> findAllArticle();

    //通过id查询文章
    public Article findArticleById(int article_id);

    //分页查询文章
    public Page<Article> findArticlePage(String query);

    //通过分类id分页查询文章
    public Page<Article> findArticlePageByClassificationId(String classification_id);

}
