package com.example.openblog.controller;

import com.example.openblog.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.openblog.service.UserService;

import javax.websocket.server.PathParam;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }
}
