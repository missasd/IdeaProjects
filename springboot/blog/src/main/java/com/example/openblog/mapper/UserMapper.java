package com.example.openblog.mapper;

import com.example.openblog.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findUserById(Integer id);
}
