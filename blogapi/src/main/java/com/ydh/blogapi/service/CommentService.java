package com.ydh.blogapi.service;

import com.ydh.blogapi.po.Comment;

import java.util.List;

/**

 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
