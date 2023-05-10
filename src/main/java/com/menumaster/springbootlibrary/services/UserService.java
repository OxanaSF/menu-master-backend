package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.dtos.UserDto;
import com.menumaster.springbootlibrary.entites.User;

import java.util.List;

public interface UserService {
    List<String> createUser(UserDto user);

    List<String> logout();

    User getUserById(long id);

    User getUserByUsername(String username);

    User updateUser(User user);
    void deleteUser(long id);

    List<String> login(UserDto userLogin);

    User saveUser(User user);

}