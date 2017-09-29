package com.creat.bookfriend.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by whz on 2017/8/25.
 */
public class FileUpLoadUtil {
    public static void upload(String path, MultipartFile pictureFile) throws IOException {
        System.out.println(path);
        File uploadPic = new File(path);
        if(!uploadPic.getParentFile().exists()){
            uploadPic.getParentFile().mkdirs();
        }
        pictureFile.transferTo(uploadPic);
    }
}
