package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookImg;

import java.util.List;

/**
 * Created by whz on 2017/9/27.
 */
public interface BookImgCustomMapper {
    List<BookImg> getBookImgsByBookInfoId(Long bookInfoId);
}
