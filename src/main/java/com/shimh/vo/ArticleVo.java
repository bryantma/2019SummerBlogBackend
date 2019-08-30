package com.shimh.vo;

import com.shimh.entity.Article;

public class ArticleVo extends Article {

    private String userName;
    private Long userId;
    private Integer year;
    private Integer month;
    private Integer tagId;
    private Integer categoryId;
    private Integer count;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", tagId=" + tagId +
                ", categoryId=" + categoryId +
                ", count=" + count +
                '}';
    }
}
