package com.cmx.controller;

import com.cmx.entity.Result;
import com.cmx.service.QiniuService;
import com.cmx.service.UserService;
import com.cmx.util.QiniuImageUtil;
import com.cmx.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/qiniu")
@CrossOrigin
public class QiniuController {
    @Autowired
    private QiniuService qiniuService;
    @Autowired
    private UserService userService;

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

    //上传预览图片
    @RequestMapping("/uploadPreviewImage")
    public Result uploadPreviewImage(@RequestParam("imgFile") MultipartFile imgFile){
        //获得文件的原始文件名
        String originalFilename = imgFile.getOriginalFilename();
        //获得文件名最后一个"."的位置
        int index = originalFilename.lastIndexOf(".");
        //获得文件的扩展名
        String extention = originalFilename.substring(index - 1);
        //随机生成一个文件名,并加上后缀
        String fileName= UUID.randomUUID().toString()+extention;
        String pathName= "imageCache/"+fileName;
        System.out.println("文件名："+pathName);
        try {
            //将文件上传至七牛云服务器
            QiniuImageUtil.upload2Qiniu(imgFile.getBytes(),pathName);
            return new Result(200,fileName,"成功",true);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(500,fileName,"失败",false);
        }
    }

    //上传头像图片
    @RequestMapping("/uploadImage")
    public Result uploadImage(@RequestParam("imgFile") MultipartFile imgFile,
                              @RequestParam("fileName") String fileName,
                              @RequestParam("user_id") int userId){
        String pathName= "userIcon/"+fileName;
        try {
            //将文件上传至七牛云服务器
            QiniuImageUtil.upload2Qiniu(imgFile.getBytes(),pathName);
            //修改数据库中用户头像地址
            userService.updateIconById(fileName,userId);
            return new Result(200,null,"成功",true);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(500,null,"失败",false);
        }
    }


}
