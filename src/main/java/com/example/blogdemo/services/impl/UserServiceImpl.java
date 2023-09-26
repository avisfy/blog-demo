package com.example.blogdemo.services.impl;

import com.example.blogdemo.services.UserService;
import com.example.blogdemo.types.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> posts = List.of(
            new User(1, "Anna", "anna@mail.com"),
            new User(2, "Alexey", null),
            new User(3, "Ivan", "ivan@mail.com")

    );

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getUsers(List<Integer> ids) {
        return null;
    }
}
