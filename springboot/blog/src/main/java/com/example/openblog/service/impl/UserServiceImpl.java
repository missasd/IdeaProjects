package com.example.openblog.service.impl;

import com.example.openblog.bean.User;

import com.example.openblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.openblog.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }
}
