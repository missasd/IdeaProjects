package com.example.papersys.controller;

import com.example.papersys.entity.User;
import com.example.papersys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return  userService.findById(id);
    }

    @GetMapping("/user")
    public String getUsers(Model model){
        model.addAttribute("msg", "hello");
        model.addAttribute("users", userService.findAll());
        return "user";
    }

    @GetMapping("/test")
    public String test(){

        return "user";
    }

    @GetMapping("/delete/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        User byId = userService.findById(id);
        userService.deleteById(id);
        return byId;
    }

}
