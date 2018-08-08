package com.blog.bean;

import java.io.Serializable;
import java.util.Date;

public class Book{
    private Integer id;
    private String bookName;
    private Integer pageNum;
    private Integer alreadyReadNum;
    private String img;
    private Date startDate;
    private Double progress;
    private String author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getAlreadyReadNum() {
        return alreadyReadNum;
    }

    public void setAlreadyReadNum(Integer alreadyReadNum) {
        this.alreadyReadNum = alreadyReadNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
