package com.example.blogdemo.services.impl;

import com.example.blogdemo.services.PostService;
import com.example.blogdemo.types.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final List<Post> posts = List.of(
            new Post(1, "Post 1", "A long post 1 text", 0, 1),
            new Post(2, "Post 2", "A long post 2 text", 5, 1),
            new Post(3, "Post 3", "A long post 3 text", 2, 3),
            new Post(4, "Post 4", "A long post 4 text", 10, 2),
            new Post(5, "Post 5 (no comments)", "A long post 5 text", 0, 2)
    );

    @Override
    public Flux<Post> getPostsByTitle(String title) {
        log.info("use getPostsByTitle()");
        return Flux.fromStream(posts.stream().filter(p->p.getTitle().contains(title)));
    }

    @Override
    public Flux<Post> getPosts() {
        log.info("use getPosts()");
        return Flux.fromIterable(posts);
    }

    @Override
    public Mono<Post> getPostById(Integer id) {
        log.info("use getPostById() with id: " + id);
        return Mono.just(posts.stream().filter(p->(p.getId()==id)).findFirst().orElse(new Post()));
    }
}
