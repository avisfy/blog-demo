package com.example.blogdemo.services.impl;

import com.example.blogdemo.services.UserService;
import com.example.blogdemo.types.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final List<User> users = List.of(
            new User(1, "Anna", "anna@mail.com"),
            new User(2, "Alexey", null),
            new User(3, "Ivan", "ivan@mail.com")

    );

    @Override
    public List<User> getUserListByIds(List<Integer> ids) {
        log.info("use getUsersByListId() with ids: " + ids);
        return users.stream().filter(u->ids.contains(u.getId())).collect(Collectors.toList());
    }
}
