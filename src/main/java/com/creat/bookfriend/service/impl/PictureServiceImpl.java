package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.service.PictureService;
import com.creat.bookfriend.utils.file.FileUpLoadUtil;
import com.creat.bookfriend.utils.uutil.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;

/**
 * Created by whz on 2017/9/25.
 */
@Service
public class PictureServiceImpl implements PictureService{

    @Value("${picture.path}")
    private String picturePath;
    @Value("${picture.picturePrefix}")
    private String picturePrefix;
    @Value("${picture.urlPrefix}")
    private String urlPrefix;
    @Value("${picture.mainUrl}")
    private String mainUrl;
    @Value("${picture.mainSuffix}")
    private String mainSuffix;

    @Override
    public String buildPictureName(String srcName) {
        int hash = Math.abs(srcName.hashCode()%24);
        return picturePrefix+hash+"/"+UUIDUtil.getUUID().toString()+srcName.substring(srcName.lastIndexOf("."));
    }

    @Override
    public String savePicture(String pictureName, MultipartFile file) throws IOException {
        String path = picturePath + pictureName;
        FileUpLoadUtil.upload(path,file);
        return urlPrefix + pictureName;
    }

    @Override
    public String createMainUrl(){
        Random random = new Random();
        int middle = random.nextInt(3);
        return mainUrl+middle+mainSuffix;
    }
}
