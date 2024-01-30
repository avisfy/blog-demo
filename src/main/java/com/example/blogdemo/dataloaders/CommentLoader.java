package com.example.blogdemo.dataloaders;

import com.example.blogdemo.services.CommentService;
import com.example.blogdemo.types.Comment;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.AllArgsConstructor;
import org.dataloader.BatchLoader;
import org.dataloader.MappedBatchLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader
@AllArgsConstructor
public class CommentLoader implements MappedBatchLoader<Integer, List<Comment>> {
    private final CommentService commentService;
    @Override
    public CompletionStage<Map<Integer, List<Comment>>> load(Set<Integer> list) {
        return CompletableFuture.supplyAsync(()->commentService.getCommentListByPostIds(new ArrayList<>(list)));
    }
}
