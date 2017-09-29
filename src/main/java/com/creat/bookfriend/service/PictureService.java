package com.creat.bookfriend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by whz on 2017/9/25.
 */
public interface PictureService {
    String buildPictureName(String srcName);
    String savePicture(String pictureName,MultipartFile file) throws IOException;
    String createMainUrl();
}
