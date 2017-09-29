package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.BookCollection;
import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.po.UserInfo;
import com.creat.bookfriend.service.BookCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by whz on 2017/9/28.
 */
@RestController
@RequestMapping("/bookCollection")
public class BookCollectionController {

    @Autowired
    private BookCollectionService bookCollectionService;

    @RequestMapping(value = "/collectBook",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message collectBook(Long bookInfoId, HttpSession session){
        Message message = new Message();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        Long userInfoId = userInfo.getId();
        bookCollectionService.collectBook(bookInfoId,userInfoId);
        message.setCode(Message.SUCCESS);
        message.setMsg("收藏成功!");
        return message;
    }
}
