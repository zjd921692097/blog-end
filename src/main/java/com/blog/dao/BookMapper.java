package com.blog.dao;

import com.blog.bean.Book;
import com.blog.param.AddBookParam;

import java.util.List;

public interface BookMapper {
    List<Book> getBooks();
    int addBook(AddBookParam param);
}
