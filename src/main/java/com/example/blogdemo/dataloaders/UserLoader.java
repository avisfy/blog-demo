package com.example.blogdemo.dataloaders;

import com.example.blogdemo.services.UserService;
import com.example.blogdemo.types.User;
import com.netflix.graphql.dgs.DgsDataLoader;
import lombok.AllArgsConstructor;
import org.dataloader.BatchLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "users")
@AllArgsConstructor
public class UserLoader implements BatchLoader<Integer, User> {
    private final UserService userService;
    @Override
    public CompletionStage<List<User>> load(List<Integer> list) {
        return CompletableFuture.supplyAsync(()->userService.getUserListByIds(list));
    }
}
