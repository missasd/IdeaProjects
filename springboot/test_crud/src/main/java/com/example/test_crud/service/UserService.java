package com.example.test_crud.service;

import com.example.test_crud.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findUserById(Integer id);
    void deleteUser(Integer id);

}
