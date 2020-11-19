package com.example.springbootmybatiscrud.service;

import com.example.springbootmybatiscrud.entity.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();


    Integer save(User user);

    Integer deleteById(Integer id);

    Integer updateUser(User user);
}
