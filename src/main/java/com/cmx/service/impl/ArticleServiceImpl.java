package com.cmx.service.impl;

import com.cmx.dao.ArticleDao;
import com.cmx.entity.Article;
import com.cmx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    //查询全部文章
    public List<Article> findAllArticle(){
        return articleDao.findAllArticle();
    }

    //通过id查询文章
    public Article findArticleById(int article_id){
        return articleDao.findArticleById(article_id);
    }
}
