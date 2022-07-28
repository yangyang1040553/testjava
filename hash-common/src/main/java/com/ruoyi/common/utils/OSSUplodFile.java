package com.ruoyi.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.UUID;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OSSUplodFile {


    public static void uploadFile(File file, String accessId, String accessKey, String endpoint,String bucket) {

        LogUtils.getBlock("accessId="+accessId);
        LogUtils.getBlock("accessKey="+accessKey);
        LogUtils.getBlock("endpoint="+endpoint);
        OSSClient ossClient = new OSSClient(endpoint, accessId, accessKey);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectMetadata.setContentEncoding("utf-8");
            //获取文件后缀名
            String ext = "erytrty.json";
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, ext, fileInputStream,objectMetadata);
            PutObjectResult re = ossClient.putObject(putObjectRequest);
//            re.setRequestId(IdUtils.getID12Str());
            ResponseMessage response = re.getResponse();
            LogUtils.getBlock("response=" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
