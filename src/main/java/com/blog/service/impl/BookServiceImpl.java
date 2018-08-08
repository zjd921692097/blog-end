package com.blog.service.impl;

import com.blog.bean.Book;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.dao.BookMapper;
import com.blog.param.AddBookParam;
import com.blog.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public ListResultEx<Book> getBooks() {
        ListResultEx<Book> resultEx=new ListResultEx<>();
        resultEx.setDataList(bookMapper.getBooks());
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx addBook(AddBookParam param) {
        param.setImg("");
        param.setAlreadyReadNum(0);
        param.setStartDate(new Date());
        int result=bookMapper.addBook(param);
        if(result!=0){
            return new ResultEx().makeSuccessResult();
        }
        return new ResultEx().makeFailedResult();
    }
}
