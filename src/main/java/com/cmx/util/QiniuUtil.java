package com.cmx.util;
import com.cmx.pojo.Directory;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 七牛云工具类
 */
public class QiniuUtil {
    public  static String accessKey = "Qf4-WECi_eV9tqAtIw9ygoVoPJzdB_2MknN1bbB1";
    public  static String secretKey = "7cQUwa_14KLKL8DoSzOprl61iOXN6e5YScxVrfT-";
    public  static String bucket = "jhun080-typora-articles";

    public static void upload2Qiniu(String filePath,String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huadong());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //上传文件
    public static void upload2Qiniu(byte[] bytes, String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huadong());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }

    //删除文件
    public static void deleteFileFromQiniu(String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }

    //获取空间文件目录列表
    public static List<Directory> getDirectoryList(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        //创建一个map用于存储主目录-子目录
        Map<String,List<String>> map=new HashMap<>();
        //循环主目录
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                if(item.key.indexOf(".md") !=-1){
                    //如果文件类型不是目录,跳过
                    continue;
                }else{
                    //现在就只剩下主、子目录了，处理并记录主、子目录
                    //获取主目录
                    String mainName=item.key.split("/")[0];
                    if(map.containsKey(mainName)){
                        //判断是否已经存储了主目录
                        //如果已经存储了,记录子目录
                        map.get(mainName).add(item.key.split("/")[1]);
                    }else {
                        //如果未存储,记录主目录
                        map.put(mainName,new ArrayList<String>());
                    }
                    //System.out.println(item.key);
//                    System.out.println(item.fsize);
//                    System.out.println(item.mimeType);
                }
            }
        }
        //创建一个目录列表
        List<Directory> directoryList = new ArrayList<Directory>();
        //将map处理成Directory对象
        for (Map.Entry<String,List<String>> item : map.entrySet()){
            //创建一个目录类
            Directory directory=new Directory(item.getKey(),item.getValue());
            //放入目录列表
            directoryList.add(directory);
        }
        return directoryList;
    }

    //获取指定文件的信息
    public static void getFileDetailByName(String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            //单次批量请求的文件数量不得超过1000
            String[] keyList = new String[]{
//                    "qiniu.jpg",
//                    "qiniu.mp4",
//                    "qiniu.png",
                    fileName,
            };
            BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
            batchOperations.addStatOps(bucket, keyList);
            Response response = bucketManager.batch(batchOperations);
            BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);
            for (int i = 0; i < keyList.length; i++) {
                BatchStatus status = batchStatusList[i];
                String key = keyList[i];
                System.out.print(key+"\t");
                if (status.code == 200) {
                    //文件存在
                    System.out.println(status.data.hash);
                    System.out.println(status.data.mimeType);
                    System.out.println(status.data.fsize);
                    System.out.println(status.data.putTime);
                } else {
                    System.out.println(status.data.error);
                }
            }
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }
    }
}
