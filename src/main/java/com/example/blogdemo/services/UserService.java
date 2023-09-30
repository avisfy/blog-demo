package com.example.blogdemo.services;

import com.example.blogdemo.types.User;

import java.util.List;

public interface UserService {
    List<User> getUserListByIds(List<Integer> ids);
}
