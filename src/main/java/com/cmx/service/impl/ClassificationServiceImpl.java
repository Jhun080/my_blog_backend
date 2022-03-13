package com.cmx.service.impl;

import com.cmx.dao.ClassificationDao;
import com.cmx.entity.Classification;
import com.cmx.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationDao classificationDao;

    //通过id查询分类标签数据
    public Classification findClassificationById(int classification_id){
        return classificationDao.findClassificationById(classification_id);
    }

    //查询全部分类标签数据
    public List<Classification> findAllClassification(){
        return classificationDao.findAllClassification();
    }
}
