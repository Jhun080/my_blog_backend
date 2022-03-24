package com.cmx.dao;

import com.cmx.pojo.Directory;
import com.cmx.util.QiniuUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class test {
    @Test
    public void test2(){
        System.out.println("111");
    }

    //测试上传文件
    @Test
    public void test1(){
        QiniuUtil.upload2Qiniu("C:\\Users\\Jhun\\Desktop\\1.png","/images/图片"+Math.random());
    }

    //测试获取文件列表
    @Test
    public void test3(){
        try {
            List<Directory> directoryList= QiniuUtil.getDirectoryList();
            System.out.println(directoryList);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    //测试获取指定文件的信息
    @Test
    public void test4(){
        QiniuUtil.getFileDetailByName("算法笔记");

    }

}
