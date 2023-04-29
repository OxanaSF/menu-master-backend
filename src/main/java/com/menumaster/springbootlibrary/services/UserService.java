package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.entites.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}
