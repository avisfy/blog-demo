package com.example.blogdemo.datafetchers;

import com.example.blogdemo.dataloaders.UserLoader;
import com.example.blogdemo.types.Comment;
import com.example.blogdemo.types.Post;
import com.example.blogdemo.types.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

@DgsComponent
public class UserDataFetcher {
    @DgsData(parentType = "Post", field = "author")
    public CompletableFuture<User> author(DgsDataFetchingEnvironment dfe) {
        DataLoader<Integer, User> dataLoader = dfe.getDataLoader(UserLoader.class);
        Post post = dfe.getSource();
        Integer id = post.getAuthorId();
        return dataLoader.load(id);
    }

    @DgsData(parentType = "Comment", field = "user")
    public CompletableFuture<User> commentUser(DataFetchingEnvironment dfe) {
        DataLoader<Integer, User> dataLoader = dfe.getDataLoader("users");
        Comment comment = dfe.getSource();
        Integer id = comment.getUserId();
        return dataLoader.load(id);
    }
}
