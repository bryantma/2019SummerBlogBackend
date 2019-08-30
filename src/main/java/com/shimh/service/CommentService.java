package com.shimh.service;

import com.shimh.entity.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> findAll();

    Comment getCommentById(Integer id);

    Integer saveComment(Comment comment);

    void deleteCommentById(Integer id);

    List<Comment> listCommentsByArticle(Integer id);

    Comment saveCommentAndChangeCounts(Comment comment);

    void deleteCommentByIdAndChangeCounts(Integer id);
}
