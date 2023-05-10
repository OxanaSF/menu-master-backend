package com.menumaster.springbootlibrary.services;

import com.menumaster.springbootlibrary.dtos.UserDto;
import com.menumaster.springbootlibrary.entites.User;
import com.menumaster.springbootlibrary.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        return userrepository.save(user);
    }


    @Override
    @Transactional
    public List<String> createUser(UserDto user) {
        List<String> response = new ArrayList<String>();
        Optional<User> existingUser = userrepository.findByUsername(user.getUsername());
        System.out.println("user.getUsername()!!!!!!! " + user.getUsername());
        if(existingUser.isPresent()) {
            response.add("User with the same username already exists!");
        } else {
            User newUser = new User(user);
            userrepository.saveAndFlush(newUser);
            response.add("OK!");
        }
        System.out.println("response!!!!!!! " + response);
        return response;
    }


    @Override
    public List<String> login(UserDto userLogin) {
        List<String> response = new ArrayList<String>();

        Optional<User> userOptional = userrepository.findByUsername(userLogin.getUsername());

        System.out.println("response userOptional !!!!!!" + userOptional);
        System.out.println("response userLogin.getUsername() !!!!!!!" + userLogin.getUsername());
        if(userOptional.isPresent()) {
            if(passwordEncoder.matches(userLogin.getPassword(), userOptional.get().getPassword())) {
                response.add(String.valueOf(userOptional.get().getUserId()));
                response.add(String.valueOf(userOptional.get().getFirstName()));
            } else {
                response.add("The password doesn't match");
            }
        } else {
            response.add("User name or password is incorrect!");
        }
        return response;
    }



    @Override
    public List<String> logout() {
        List<String> response = new ArrayList<String>();

        response.add("User successfully logged out.");
        return response;
    }


    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }


}