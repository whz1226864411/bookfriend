package com.creat.bookfriend.dao;

import com.creat.bookfriend.mapper.BookImgMapper;
import com.creat.bookfriend.po.BookImg;
import com.creat.bookfriend.po.BookImgExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */
@Repository
public class BookImgDAO {
    @Autowired
    private BookImgMapper bookImgMapper;

    public List<BookImg> selectBookImgsByBookInfoId(Long bookInfoId){
        BookImgExample example = new BookImgExample();
        BookImgExample.Criteria criteria = example.createCriteria();
        criteria.andBookInfoIdEqualTo(bookInfoId);
        return bookImgMapper.selectByExample(example);
    }
    public void saveBookImgs(List<BookImg> bookImgs){
        for(BookImg bookImg : bookImgs){
            saveBookImg(bookImg);
        }
    }

    public void saveBookImg(BookImg bookImg){
        bookImgMapper.insert(bookImg);
    }
}
