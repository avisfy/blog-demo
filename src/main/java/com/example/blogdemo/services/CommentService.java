package com.example.blogdemo.services;

import com.example.blogdemo.types.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    Map<Integer, List<Comment>> getCommentListByPostIds(List<Integer> postIds);
}
