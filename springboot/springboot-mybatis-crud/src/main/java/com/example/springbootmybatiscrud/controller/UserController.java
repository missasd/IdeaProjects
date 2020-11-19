package com.example.springbootmybatiscrud.controller;

import com.example.springbootmybatiscrud.entity.User;
import com.example.springbootmybatiscrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    // 插入
    @PostMapping("/insert")
    public User insertUser(User user){
        userService.save(user);
        return user;
    }

    @PostMapping("/update")
    public Integer updateUser(User user){
        return userService.updateUser(user);

    }

    @DeleteMapping("/delete/{id}")
    public Integer deleteById(@PathVariable("id") Integer id){
        User byId = userService.findById(id);
        if (byId == null){
            return -1;
        }else {
            return userService.deleteById(id);
        }
    }
}
