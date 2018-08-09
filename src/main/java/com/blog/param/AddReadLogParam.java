package com.blog.param;

import java.io.Serializable;
import java.util.Date;

public class AddReadLogParam implements Serializable {
    private Integer bookId;
    private Integer readNum;
    private Date readDate;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }
}
