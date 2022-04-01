package com.example.upload_demo.service.impl;

import com.example.upload_demo.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("UploadServiceImpl")
public class UploadServiceImpl implements UploadService {

    /**
     *  文件的上传路劲!
     */
    @Value("${upload}")
    String filePath;


    @Override
    public String saveFile(MultipartFile file) {
        if (file.isEmpty()){
            return "未选择文件";
        }
        /**
         *  给上传的文件,一个不会重复的名称!
         */
        String filename = UUID.randomUUID().toString();
        /**
         *  文件夹的是否存在!
         */
        File temp = new File(filePath);
        if (!temp.exists()){
            temp.mkdirs();
        }
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileUpLoadName = filePath + filename + suffix;
        File localFile = new File(fileUpLoadName);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
            System.out.println("文件上传后位置: " + fileUpLoadName);
        }catch ( IOException e){
            e.printStackTrace();
            return "上传失败";
        }
        return  fileUpLoadName;
    }
}
