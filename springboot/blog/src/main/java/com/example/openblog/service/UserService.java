package com.example.openblog.service;

import com.example.openblog.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // 根据id查询user
    User findUserById(Integer id);
}
