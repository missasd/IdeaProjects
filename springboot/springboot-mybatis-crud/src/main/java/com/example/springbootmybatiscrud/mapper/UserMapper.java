package com.example.springbootmybatiscrud.mapper;

import com.example.springbootmybatiscrud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();


    Integer save(User user);

    Integer deleteById(Integer id);

    Integer updateUser(User user);
}
