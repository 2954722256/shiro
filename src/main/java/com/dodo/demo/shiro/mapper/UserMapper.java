package com.dodo.demo.shiro.mapper;


import com.dodo.demo.shiro.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByUsername(@Param("username") String username);
}
