package com.example.blogdemo.services.impl;

import com.example.blogdemo.services.CommentService;
import com.example.blogdemo.types.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    private final List<Comment> comments = List.of(
            new Comment(1, "Good post!", 1, 4),
            new Comment(2, "Ok", 2, 3),
            new Comment(3, "Like it", 3, 4),
            new Comment(4, "How is it work?", 2, 1),
            new Comment(5, "Exactly", 1, 2)
    );

    @Override
    public Map<Integer, List<Comment>> getCommentListByPostIds(List<Integer> ids) {
        log.info("use getCommentListByPostIds() with ids: " + ids);
        return comments.stream().filter(c->ids.contains(c.getPostId())).collect(groupingBy(Comment::getPostId));
    }
}
