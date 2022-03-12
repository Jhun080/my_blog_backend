package com.cmx.dao;

import com.cmx.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDao {
    //查询全部文章1
    public List<Article> findAllArticle();
}
