package com.example.test_crud.mapper;

import com.example.test_crud.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User findUserById(Integer id);

    void deleteUser(Integer id);
}
