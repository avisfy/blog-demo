package com.example.blogdemo.services;

import com.example.blogdemo.types.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    List<User> getUsers(List<Integer> ids);
}
