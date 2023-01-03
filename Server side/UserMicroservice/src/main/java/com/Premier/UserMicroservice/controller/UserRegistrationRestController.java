package com.Premier.UserMicroservice.controller;

import com.Premier.UserMicroservice.model.User;
import com.Premier.UserMicroservice.service.UserService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/register")
@CrossOrigin()
public class UserRegistrationRestController {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> registerUser(@RequestBody User userinfo) {
        if (Strings.isNullOrEmpty(userinfo.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserByUsernameContaining(userinfo.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        User newUser = new User(userinfo.getUsername());
        newUser.setEmail(userinfo.getEmail());
        // Encoding password with Spring Security PassWord Encoder
        newUser.setPassword(passwordEncoder.encode(userinfo.getPassword()));
        newUser.setUserId(String.valueOf(Math.random() * 10_000_000));
        userService.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}
