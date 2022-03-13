package com.cmx.service;

import com.cmx.entity.Classification;

import java.util.List;

public interface ClassificationService {
    //通过id查询分类标签数据
    public Classification findClassificationById(int classification_id);
    //查询全部分类标签数据
    public List<Classification> findAllClassification();
}
