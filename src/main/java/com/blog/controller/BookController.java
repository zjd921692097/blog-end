package com.blog.controller;

import com.blog.bean.Book;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.param.AddBookParam;
import com.blog.param.AddReadLogParam;
import com.blog.param.GetReadStatisticsParam;
import com.blog.service.BookService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.PAData;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping(value = "/book", name = "书籍相关")
public class BookController {
    @Resource
    BookService bookService;


    @RequestMapping(value = "/getBooks" ,method = RequestMethod.POST)
    @ResponseBody
    public ListResultEx<Book> getBooks(){
        return bookService.getBooks();
    }


    @RequestMapping(value = "/addBook" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultEx addBook(AddBookParam param, HttpServletRequest request){
        if(request.getSession().getAttribute("USER")==null || request.getSession().getAttribute("USER")==""){
            return new ResultEx().makeFailedResult("please login");
        }
        return bookService.addBook(param);
    }

    @RequestMapping(value = "/addReadLog" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultEx addReadLog(AddReadLogParam param, HttpServletRequest request){
        if(request.getSession().getAttribute("USER")==null || request.getSession().getAttribute("USER")==""){
            return new ResultEx().makeFailedResult("please login");
        }
        return bookService.addReadLog(param);
    }

    @RequestMapping(value = "/getReadStatistics" ,method = RequestMethod.POST)
    @ResponseBody
    public ResultEx getReadStatistics(GetReadStatisticsParam param){
        return bookService.getReadStatistics(param);
    }

}
