package com.example.papersys.service;

import com.example.papersys.entity.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    void updateUser(User user);

    void insertUser(User user);

    void deleteById(Integer id);

}
