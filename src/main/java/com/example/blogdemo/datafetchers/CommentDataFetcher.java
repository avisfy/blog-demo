package com.example.blogdemo.datafetchers;

import com.example.blogdemo.dataloaders.CommentLoader;
import com.example.blogdemo.types.Comment;
import com.example.blogdemo.types.Post;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class CommentDataFetcher {
    @DgsData(parentType = "Post", field = "comments")
    public CompletableFuture<List<Comment>> comment(DgsDataFetchingEnvironment dfe) {
        DataLoader<Integer, List<Comment>> dataLoader = dfe.getDataLoader(CommentLoader.class);
        Post post = dfe.getSource();
        Integer postId = post.getId();
        return dataLoader.load(postId);
    }
}
