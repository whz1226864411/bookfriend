package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.po.PictureMessage;
import com.creat.bookfriend.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by whz on 2017/9/25.
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/getMainPicture",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getMainPicture(){
        PictureMessage message = new PictureMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setPicUrl(pictureService.createMainUrl());
        return message;
    }

    @RequestMapping(value = "/uploadPicture",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
                    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Message uploadPicture(MultipartFile picture){
        PictureMessage message = new PictureMessage();
        try {
            String picName = pictureService.buildPictureName(picture.getOriginalFilename());
            String url = pictureService.savePicture(picName,picture);
            message.setCode(Message.SUCCESS);
            message.setMsg("上传成功!");
            message.setPicUrl(url);
        } catch (IOException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            message.setMsg("上传失败!");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return message;
    }

}
