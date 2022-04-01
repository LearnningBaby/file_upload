package com.example.upload_demo.controller;

import com.example.upload_demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class UpLoadController {

    @Autowired
    @Qualifier("UploadServiceImpl")
    private UploadService uploadService;

    /**
     *  调用 uploadService 的 saveFile 方法 将文件保存到本地!
     *  并返回保存后文件的位置以及文件名,可以把这个返回值写道数据库中!
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file){
        System.out.println( uploadService.saveFile(file));
        return "ok";
    }

}