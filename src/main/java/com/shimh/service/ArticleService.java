package com.shimh.service;

import com.shimh.entity.Article;
import com.shimh.vo.ArticleVo;
import com.shimh.vo.PageVo;

import java.util.List;


public interface ArticleService {

    List<Article> listArticles(PageVo page);

    List<Article> listArticles(ArticleVo article, PageVo page);

    List<Article> findAll();

    Article getArticleById(Integer id);

    Integer publishArticle(Article article);

    Integer saveArticle(Article article);

    Integer updateArticle(Article article);

    void deleteArticleById(Integer id);

    List<Article> listArticlesByTag(Integer id);

    List<Article> listArticlesByCategory(Integer id);

    List<Article> listArticlesByUser(Long userID);

    List<Article> listArticlesByTitleLike(String pattern);

    Article getArticleAndAddViews(Integer id);

    List<Article> listHotArticles(int limit);

    List<Article> listNewArticles(int limit);

    List<ArticleVo> listArchives();
}
