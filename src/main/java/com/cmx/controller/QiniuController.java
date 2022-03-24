package com.cmx.controller;

import com.cmx.entity.Result;
import com.cmx.service.QiniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/qiniu")
@CrossOrigin
public class QiniuController {
    @Autowired
    private QiniuService qiniuService;

    //查找服务器目录信息
    @CrossOrigin
    @GetMapping("/getDirectory")
    public Result getDirectory(){
        try {
            return new Result(200,qiniuService.getDirectory(),"成功",true);
        }catch (Exception e){
            return new Result(500,null,"失败",false);
        }
    }


}
