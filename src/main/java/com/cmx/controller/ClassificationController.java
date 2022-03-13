package com.cmx.controller;

import com.cmx.dao.CategoryDao;
import com.cmx.entity.Category;
import com.cmx.entity.Classification;
import com.cmx.entity.Result;
import com.cmx.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classification")
@CrossOrigin
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    //通过id查询分类标签数据
    @CrossOrigin
    @GetMapping("/findClassificationById")
    public Result findClassificationById(int classification_id){
        try {
            return new Result(200,classificationService.findClassificationById(classification_id),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    //查询全部分类标签数据
    @CrossOrigin
    @GetMapping("/findAllClassification")
    public Result findAllClassification(){
        try {
            return new Result(200,classificationService.findAllClassification(),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }

    @Autowired
    private CategoryDao categoryDao;

    //通过id查询分类标签数据
    @CrossOrigin
    @GetMapping("/find")
    public Result findCategoryByArticleId(int article_id){
        try {
            return new Result(200,categoryDao.findCategoryByArticleId(article_id),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }


}
