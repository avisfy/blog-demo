package com.example.blogdemo.services;

import com.example.blogdemo.types.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostService {
    Flux<Post> getPostsByTitle(String title);
    Flux<Post> getPosts();

    Mono<Post> getPostById(Integer id);
}
