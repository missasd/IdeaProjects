package com.example.papersys.mapper;

import com.example.papersys.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();

    void updateUser(User user);

    void insertUser(User user);

    void deleteById(Integer id);

}
