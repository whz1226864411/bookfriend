package com.creat.bookfriend.service.impl;

import com.creat.bookfriend.dao.BookBriefDAO;
import com.creat.bookfriend.dao.BookImgDAO;
import com.creat.bookfriend.dao.BookInfoDAO;
import com.creat.bookfriend.dao.BorrowHistoryDAO;
import com.creat.bookfriend.po.*;
import com.creat.bookfriend.service.BookInfoService;
import com.creat.bookfriend.utils.http.MyHttpClient;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
@Service
public class BookInfoServiceImpl implements BookInfoService{

    @Autowired
    private BookInfoDAO bookInfoDAO;
    @Autowired
    private BookImgDAO bookImgDAO;
    @Autowired
    private BookBriefDAO bookBriefDAO;
    @Autowired
    private BorrowHistoryDAO borrowHistoryDAO;


    @Value("${douban.url}")
    private String doubanUrl;

    @Override
    @Transactional
    public void saveBookInfoCustom(BookInfoCustom bookInfoCustom) {
        BookBrief bookBrief = bookInfoCustom.getBookBrief();
        List<BookImg> bookImgs = bookInfoCustom.getBookImgs();
        //保存简述,设置日期
        completeBookBrief(bookBrief);
        bookBriefDAO.saveBookBrief(bookBrief);
        //保存bookInfo,设置日期,设置bookBriefId
        bookInfoCustom.setBookBriefId(bookBrief.getId());
        completeBookInfoCustom(bookInfoCustom);
        bookInfoDAO.saveBookInfo(bookInfoCustom);
        //保存图片,设置bookInfoId,设置日期
        completeBookImgs(bookImgs,bookInfoCustom.getId());
        bookImgDAO.saveBookImgs(bookImgs);
    }
    //从豆瓣api获取图书信息
    @Override
    public BookInfo getBookInfoByIsbn(Long isbn) throws IOException {
        JSONObject bookObject = requestBookByIsbn(String.valueOf(isbn));
        return getBookInfoFromJson(bookObject);
    }

    @Override
    @Transactional
    public BookInfoCustom getBookInfoCustomById(Long bookInfoId) {
        return bookInfoDAO.getBookCustomByBookInfoId(bookInfoId);
    }

    @Override
    @Transactional
    public BookInfoDetail getBookInfoDetailById(Long bookInfoId) {
        return bookInfoDAO.getBookInfoDetailById(bookInfoId);
    }

    @Override
    @Transactional
    public List<BookInfo> getBookInfoByUserInfoId(Long userInfoId) {
        return bookInfoDAO.getBookInfoByUserInfoId(userInfoId);
    }

    @Override
    @Transactional
    public List<BookInfo> getSameCityBooks(Long cityId, Integer num) {
        return bookInfoDAO.getBookInfoByCityId(cityId,num);
    }

    @Override
    @Transactional
    public List<BookInfo> getInterestBooks(Long userInfoId, Integer num) {
        return bookInfoDAO.getBooksLimit(num);
    }

    @Override
    @Transactional
    public List<BookInfo> selectBooksByBookName(String bookName) {
        return bookInfoDAO.selectBookInfoByBookName(bookName);
    }

    @Override
    @Transactional
    public List<BookInfo> getBorrowedBooks(Long userInfoId,Integer rows) {
        return bookInfoDAO.getBorrowedBooks(userInfoId,rows);
    }

    @Override
    @Transactional
    public List<BookInfo> getReadBooks(Long userInfoId, Integer rows) {
        return bookInfoDAO.getReadBooks(userInfoId,rows);
    }

    @Override
    @Transactional
    public List<BookInfo> getCollectionBooks(Long userInfoId, Integer rows) {
        return bookInfoDAO.getCollectionBooks(userInfoId,rows);
    }

    @Override
    @Transactional
    public void finishReadBook(Long bookInfoId, Long userInfoId) {
        List<BorrowHistory> borrowHistoryList = borrowHistoryDAO.getBorrowedBook(userInfoId,bookInfoId);
        if(borrowHistoryList.size() > 0){
            BorrowHistory borrowHistory = borrowHistoryList.get(0);
            borrowHistory.setState(new Byte("1"));
            borrowHistory.setGmtModified(new Date());
            borrowHistoryDAO.updateBorrowHistory(borrowHistory);
        }
    }

    //封装图书信息
    private BookInfo getBookInfoFromJson(JSONObject object){
        BookInfo bookInfo = null;
        if(!object.containsKey("msg")){
            bookInfo = new BookInfo();
            bookInfo.setAuthor(object.getJSONArray("author").getString(0));
            bookInfo.setBookName(object.getString("title"));
            bookInfo.setCoverImg(object.getString("image"));
        }
        return bookInfo;
    }
    //发送请求
    private JSONObject requestBookByIsbn(String isbn) throws IOException {
        String url = doubanUrl+isbn;
        MyHttpClient client = new MyHttpClient();
        String json = client.sendGet(url);
        client.closeClient();
        return JSONObject.fromObject(json);
    }

    private void completeBookImgs(List<BookImg> bookImgs, Long bookInfoId){
        for(BookImg bookImg : bookImgs){
            bookImg.setBookInfoId(bookInfoId);
            bookImg.setGmtCreate(new Date());
            bookImg.setGmtModified(new Date());
        }
    }
    private void completeBookBrief(BookBrief bookBrief){
        bookBrief.setGmtCreate(new Date());
        bookBrief.setGmtModified(new Date());
    }

    private void completeBookInfoCustom(BookInfoCustom bookInfoCustom){
        bookInfoCustom.setGmtCreate(new Date());
        bookInfoCustom.setGmtModified(new Date());
        bookInfoCustom.setState(new Byte("0"));
    }

}
