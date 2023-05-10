package com.menumaster.springbootlibrary.controllers;

import com.menumaster.springbootlibrary.dtos.UserDto;
import com.menumaster.springbootlibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")

        private List<String> register(@RequestBody UserDto userRegister) {
        System.out.println("Start");
        String encodePasword = passwordEncoder.encode(userRegister.getPassword());
        userRegister.setPassword(encodePasword);
        return userService.createUser(userRegister);
    };

    @PostMapping("/login")

    private List<String> login(@RequestBody UserDto userRegister) {
        return userService.login(userRegister);
    };

    @PostMapping("/logout")
    private List<String> logout() {
        return userService.logout();
    };






//    @PostMapping("/")
//    public ResponseEntity<List<String>> createUser(@RequestBody UserDto user) {
//        List<String> savedUser = userService.createUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.getUserById(id);
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        User existingUser = userService.getUserById(id);
//        if (existingUser == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            user.setUserId(id);
//            User updatedUser = userService.updateUser(user);
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
//        User existingUser = userService.getUserById(id);
//        if (existingUser == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            userService.deleteUser(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }


}
