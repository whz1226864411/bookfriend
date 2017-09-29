package com.creat.bookfriend.controller;

import com.creat.bookfriend.po.*;
import com.creat.bookfriend.service.BookInfoService;
import com.creat.bookfriend.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by whz on 2017/9/26.
 */
@RestController
@RequestMapping("/bookInfo")
public class BookInfoController {

    private Logger logger = LoggerFactory.getLogger(BookInfoController.class);

    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private PlaceService placeService;


    //根据userInfoId获取发布书籍信息
    @RequestMapping(value = "/getPublishedBookByUserId",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getPublishedBookByUserId(Long userInfoId){
        BooksMessage message = new BooksMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getBookInfoByUserInfoId(userInfoId));
        return message;
    }

    @RequestMapping(value = "/getCollectionBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getCollectionBooks(Integer rows,HttpSession session){
        BooksMessage message = new BooksMessage();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getCollectionBooks(userInfo.getId(),rows));
        return message;
    }

    @RequestMapping(value = "/finishReadBook",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message finishReadBook(Long bookInfoId, HttpSession session){
        Message message = new Message();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        bookInfoService.finishReadBook(bookInfoId,userInfo.getId());
        return message;
    }

    @RequestMapping(value = "/getReadBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getReadBooks(Integer rows, HttpSession session){
        BooksMessage message = new BooksMessage();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getReadBooks(userInfo.getId(),rows));
        return message;
    }

    @RequestMapping(value = "/getBorrowedBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getBorrowedBooks(Integer rows, HttpSession session){
        BooksMessage message = new BooksMessage();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getBorrowedBooks(userInfo.getId(),rows));
        return message;
    }

    //根据书名搜索图书
    @RequestMapping(value = "/searchBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message searchBooks(String bookName){
        BooksMessage message = new BooksMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.selectBooksByBookName(bookName));
        return message;
    }

    //获取兴趣图书
    @RequestMapping(value = "/getInterestBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getInterestBooks(Integer num,HttpSession session){
        BooksMessage message = new BooksMessage();
        if(num == null){
            message.setCode(Message.PARAMS_ERROR);
            message.setMsg("参数错误!");
            return message;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Long userInfoId = null;
        if(userInfo != null){
            userInfoId = userInfo.getId();
        }
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getInterestBooks(userInfoId,num));
        return message;
    }

    //探索同城图书
    @RequestMapping(value = "/getSameCityBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getSameCityBooks(Integer num,String cityName){
        BooksMessage message = new BooksMessage();
        if(num == null || cityName == null || cityName.isEmpty()){
            message.setCode(Message.PARAMS_ERROR);
            message.setMsg("参数错误!");
            return message;
        }
        City city = placeService.getCityByCityName(cityName);
        Long cityId = null;
        if(city != null){
            cityId = city.getCityId();
        }
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getSameCityBooks(cityId,num));
        return message;
    }

    //推荐书籍
    @RequestMapping(value = "/recommendBooks",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message recommendBooks(HttpSession session){
        BooksMessage message = new BooksMessage();
        //待完善开发
        message.setCode(Message.SUCCESS);
        message.setMsg("借口未完善!");
        return message;
    }

    //获取自己已发布的书籍
    @RequestMapping(value = "/getPublishedBook",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getPublishedBook(HttpSession session){
        BooksMessage message = new BooksMessage();
        Long userInfoId = ((UserInfo)session.getAttribute("userInfo")).getId();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoList(bookInfoService.getBookInfoByUserInfoId(userInfoId));
        return message;
    }
    //获取详细的图书信息
    @RequestMapping(value = "/getDetailBookInfo",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getDetailBookInfo(Long id){
        BookInfoDetailMessage message = new BookInfoDetailMessage();
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        message.setBookInfoDetail(bookInfoService.getBookInfoDetailById(id));
        return message;
    }

    //发布图书信息,登录拦截
    @RequestMapping(value = "/publishBookInfo",method = {RequestMethod.POST},
                    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
                    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Message publishBookInfo(@RequestBody BookInfoCustom bookInfoCustom, HttpSession session){
        Message message = new Message();
        Long userInfoId = ((UserInfo)session.getAttribute("userInfo")).getId();
        bookInfoCustom.setUserInfoId(userInfoId);
        bookInfoService.saveBookInfoCustom(bookInfoCustom);
        message.setCode(Message.SUCCESS);
        message.setMsg("请求成功!");
        return message;
    }
    //通过isbn自动加载书籍信息
    @RequestMapping(value = "/getBookInfoByIsbn",method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Message getBookInfoByIsbn(Long isbn){
        BookInfoMessage message = new BookInfoMessage();
        try {
            BookInfo bookInfo = bookInfoService.getBookInfoByIsbn(isbn);
            if(bookInfo != null){
                message.setCode(Message.SUCCESS);
                message.setMsg("请求成功!");
                message.setBookInfo(bookInfo);
            }else {
                message.setCode(BookInfoMessage.NOT_GET_BOOK_INFO);
                message.setMsg("未查询到图书信息!");
                logger.info("该isbn:"+isbn+" 未查询到.");
            }
        } catch (IOException e) {
            message.setCode(Message.UNKNOWN_ERROR);
            message.setMsg("未知错误!");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return message;
    }
}
