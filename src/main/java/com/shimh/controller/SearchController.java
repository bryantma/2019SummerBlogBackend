package com.shimh.controller;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.shimh.common.annotation.LogAnnotation;
import com.shimh.common.result.Result;
import com.shimh.entity.Article;
import com.shimh.entity.Tag;
import com.shimh.entity.User;
import com.shimh.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yirany
 * @version 1.0
 * @since 8/28/2019
 **/
@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/byTitle/{keyword}")
    @FastJsonView(
            exclude = {
                    @FastJsonFilter(clazz = Article.class, props = {"body", "category", "comments"}),
                    @FastJsonFilter(clazz = Tag.class, props = {"id", "avatar"})},
            include = {@FastJsonFilter(clazz = User.class, props = {"nickname"})})
    @LogAnnotation(module = "搜索", operation = "搜索标题")
    public Result searchByTitle(@PathVariable String keyword) {
        String pattern = String.format("%%%s%%", keyword);
        System.out.println("Search by pattern " + pattern);
        List<Article> articles = articleService.listArticlesByTitleLike(pattern);
        return Result.success(articles);
    }

}
