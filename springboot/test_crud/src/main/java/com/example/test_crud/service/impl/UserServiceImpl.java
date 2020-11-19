package com.example.test_crud.service.impl;

import com.example.test_crud.entity.User;
import com.example.test_crud.mapper.UserMapper;
import com.example.test_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;


@Service
public class UserServiceImpl implements UserService{

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void deleteUser(Integer id){
        userMapper.deleteUser(id);

    }
}
