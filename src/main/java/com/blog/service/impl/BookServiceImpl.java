package com.blog.service.impl;

import com.blog.bean.Book;
import com.blog.common.resultUtil.DateUtil;
import com.blog.common.resultUtil.ListResultEx;
import com.blog.common.resultUtil.ResultEx;
import com.blog.dao.BookMapper;
import com.blog.param.AddBookParam;
import com.blog.param.AddReadLogParam;
import com.blog.param.GetReadStatisticsParam;
import com.blog.result.ReadStatisticsView;
import com.blog.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public ListResultEx<Book> getBooks() {
        ListResultEx<Book> resultEx=new ListResultEx<>();
        List<Book> books=bookMapper.getBooks();
        books.stream().forEach(a->{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String sd = sdf.format(a.getStartDate());
            a.setStartDateString(sd);
        });
        resultEx.setDataList(books);
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

    @Override
    @Transactional
    public ResultEx addReadLog(AddReadLogParam param) {
        param.setReadDate(new Date());
        List<Book> books=bookMapper.getBooks();
        Book book=new Book();
        for(int i=0;i<books.size();i++){
            book=books.get(i);
        }
        if(book.getAlreadyReadNum()+param.getReadNum()>book.getPageNum()){
            return new ResultEx().makeFailedResult("没那么多页数了");
        }
        bookMapper.addAlreadyReadNum(param);
        int result= bookMapper.addBookReadLog(param);
        if(result!=0){
            return new ResultEx().makeSuccessResult();
        }
        return new ResultEx().makeFailedResult();
    }

    @Override
    public ResultEx getReadStatistics(GetReadStatisticsParam param) {
        int result=0;
        ReadStatisticsView view=new ReadStatisticsView();
        param.setStartTime(DateUtil.afterDays(3));
        param.setFinishTime(new Date());
        view.setCountThreeDay((bookMapper.getReadStatistics(param)==null)?result:bookMapper.getReadStatistics(param));
        param.setStartTime(DateUtil.afterDays(7));
        view.setCountWeek((bookMapper.getReadStatistics(param)==null)?result:bookMapper.getReadStatistics(param));
        //由于本人忍受不了一周不学习看书，所以此处留个BUG，1周不看书系统会凉凉
        param.setStartTime(DateUtil.afterDays(30));
        view.setCountMouth(bookMapper.getReadStatistics(param));
        param.setStartTime(DateUtil.afterDays(365));
        view.setCountYer(bookMapper.getReadStatistics(param));
        Book book=bookMapper.getRecentRead();
        view.setBookName(book.getBookName());
        ResultEx resultEx=new ResultEx();
        resultEx.setData(view);
        return resultEx.makeSuccessResult();
    }
}
