package com.creat.bookfriend.mapper;

import com.creat.bookfriend.po.BookInfo;
import com.creat.bookfriend.po.BookInfoCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by whz on 2017/9/27.
 */
public interface BookInfoCustomMapper {

    BookInfoCustom selectBookInfoCustomById(Long bookInfoId);
    List<BookInfo> selectBooksByCityId(@Param("cityId") Long cityId,@Param("rows") Integer rows);
    List<BookInfo> selectBooksLimit(@Param("rows") Integer rows);
    List<BookInfo> selectBorrowedBook(@Param("userInfoId")Long userInfoId,@Param("rows") Integer rows);
    List<BookInfo> selectReadBook(@Param("userInfoId")Long userInfoId,@Param("rows") Integer rows);
    List<BookInfo> selectCollectionBook(@Param("userInfoId")Long userInfoId,@Param("rows") Integer rows);

}
