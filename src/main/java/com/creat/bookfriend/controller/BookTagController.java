package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.BookTag;
import com.creat.bookfriend.po.BookTagMessage;
import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.service.BookTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whz on 2017/9/26.
 */
@RestController
@RequestMapping("/bookTag")
public class BookTagController {

    @Autowired
    private BookTagService bookTagService;

    @RequestMapping(value = "/getBookTags",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getBookTags(Integer categoryId){
        BookTagMessage message = new BookTagMessage();
        if(categoryId == null){
            message.setCode(Message.PARAMS_ERROR);
            message.setMsg("categoryId不能为空!");
            return message;
        }
        message.setBookTags(bookTagService.getBookTagsByCategoryId(categoryId));
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        return message;
    }
}
