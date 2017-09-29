package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.BookCategoryMessage;
import com.creat.bookfriend.po.Message;
import com.creat.bookfriend.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by whz on 2017/9/26.
 */
@RestController
@RequestMapping("/category")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @RequestMapping(value = "/getAllBookCategory",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getAllBookCategory(){
        BookCategoryMessage message = new BookCategoryMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookCategories(bookCategoryService.getAllBookCategory());
        return message;
    }
}
