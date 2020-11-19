package com.example.test_crud.controller;

import com.example.test_crud.entity.User;
import com.example.test_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/user/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }
}
