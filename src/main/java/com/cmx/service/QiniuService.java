package com.cmx.service;

import com.cmx.pojo.Directory;

import java.util.List;

public interface QiniuService {
    //获取服务器文件目录
    public List<Directory> getDirectory();
}
