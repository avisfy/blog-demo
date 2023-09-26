package com.example.blogdemo.datafetchers;

import com.example.blogdemo.services.PostService;
import com.example.blogdemo.types.Post;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@DgsComponent
@AllArgsConstructor
public class PostDataFetcher {
    private final PostService postService;

    @DgsQuery
    public Flux<Post> posts(@InputArgument String titleFilter) {
        if (titleFilter == null) {
            return postService.getPosts();
        }
        return postService.getPostsByTitle(titleFilter);
    }

}
