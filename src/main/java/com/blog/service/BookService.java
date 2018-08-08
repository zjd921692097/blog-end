package com.blog.service;

import com.blog.bean.Book;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.param.AddBookParam;


public interface BookService {
    ListResultEx<Book> getBooks();
    ResultEx addBook(AddBookParam param);
}
