package com.cmx.dao;

import com.cmx.entity.Classification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationDao {

    //通过id查询分类标签数据
    public Classification findClassificationById(int classification_id);

    //查询全部分类标签数据
    public List<Classification> findAllClassification();
}
