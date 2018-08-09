package com.blog.dao;

import com.blog.bean.Book;
import com.blog.param.AddBookParam;
import com.blog.param.AddReadLogParam;
import com.blog.param.GetReadStatisticsParam;

import java.util.List;

public interface BookMapper {
    List<Book> getBooks();
    int addBook(AddBookParam param);
    int addBookReadLog(AddReadLogParam param);
    int addAlreadyReadNum(AddReadLogParam param);
    Integer getReadStatistics(GetReadStatisticsParam param);
}
