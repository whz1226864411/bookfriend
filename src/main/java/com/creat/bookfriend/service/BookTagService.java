package com.creat.bookfriend.service;

import com.creat.bookfriend.po.BookTag;

import java.util.List;

/**
 * Created by whz on 2017/9/26.
 */
public interface BookTagService {

    List<BookTag> getBookTagsByCategoryId(Integer categoryId);
}
