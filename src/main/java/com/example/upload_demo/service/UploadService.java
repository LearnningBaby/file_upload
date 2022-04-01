package com.example.upload_demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     *  将文件保存到本地,并返回文件保存的路径 即文件的位置!
     * @param file
     * @return
     */
    String saveFile(MultipartFile file);

}
