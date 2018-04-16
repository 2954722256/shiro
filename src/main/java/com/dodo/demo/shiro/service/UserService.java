package com.dodo.demo.shiro.service;


import com.dodo.demo.shiro.model.User;

public interface UserService {

    User findByUsername(String username);
}
