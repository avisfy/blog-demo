package com.example.blogdemo.services.impl;

import com.example.blogdemo.services.PostService;
import com.example.blogdemo.types.Post;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> posts = List.of(
            new Post(1, "Post 1", "A long post 1 text", 0, 1),
            new Post(2, "Post 2", "A long post 2 text", 5, 1),
            new Post(3, "Post 3", "A long post 3 text", 2, 3),
            new Post(4, "Post 4", "A long post 4 text", 10, 2)
    );

    @Override
    public Flux<Post> getPostsByTitle(String title) {
        return Flux.fromStream(posts.stream().filter(p->p.getTitle().contains(title)));
    }

    @Override
    public Flux<Post> getPosts() {
        return Flux.fromIterable(posts);
    }

    @Override
    public Mono<Post> getPostById(Integer id) {
        return Mono.just(posts.stream().filter(p->(p.getId()==id)).findFirst().orElse(new Post()));
    }
}
