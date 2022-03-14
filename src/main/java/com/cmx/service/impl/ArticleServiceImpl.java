package com.cmx.service.impl;

import com.cmx.dao.ArticleDao;
import com.cmx.entity.Article;
import com.cmx.entity.PageResult;
import com.cmx.entity.QueryPage;
import com.cmx.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    //分页查询文章
    public PageResult findArticlePage(QueryPage queryPage){
        //当前页码
        Integer currentPage = queryPage.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPage.getPageSize();
        //查询条件
        String query = queryPage.getQuery();
        //完成分页查询，基于Mybatis提供的分页助手插件
        PageHelper.startPage(currentPage,pageSize);
        Page<Article> page = articleDao.findArticlePage(query);
        List<Article> rows = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,rows);
    }
}
