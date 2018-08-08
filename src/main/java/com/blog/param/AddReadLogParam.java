package com.blog.param;

import java.io.Serializable;

public class AddReadLogParam implements Serializable {
    private Integer bookId;
    private Integer readNum;

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
}
