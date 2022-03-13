package com.cmx.dao;

import com.cmx.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    //通过文章id查询关联
    public List<Category> findCategoryByArticleId(int article_id);

}
