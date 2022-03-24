package com.cmx.service.impl;

import com.cmx.pojo.Directory;
import com.cmx.service.QiniuService;
import com.cmx.util.QiniuUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QiniuServiceImpl implements QiniuService {

    //获取服务器文件目录
    public List<Directory> getDirectory(){
        return QiniuUtil.getDirectoryList();
    }

}
