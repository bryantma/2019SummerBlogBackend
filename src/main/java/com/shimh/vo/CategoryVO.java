package com.shimh.vo;

import com.shimh.entity.Category;

public class CategoryVO extends Category {

    private static final long serialVersionUID = -2975739216517528014L;


    private int articles;

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }
}
