package com.Premier.UserMicroservice.controller;

import com.Premier.UserMicroservice.Data;
import com.Premier.UserMicroservice.Message;
import com.Premier.UserMicroservice.model.User;
import com.Premier.UserMicroservice.service.UserService;
import com.google.common.base.Strings;
import org.jasypt.util.text.AES256TextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/register")
@CrossOrigin()
public class UserRegistrationRestController {
    private static Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);
    @Autowired
    private UserService userService;

    @Autowired
    AES256TextEncryptor textEncryptor;


    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> registerUser(@RequestBody User userinfo) {
        if (Strings.isNullOrEmpty(userinfo.getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserByUsername(userinfo.getUsername()).isPresent()){
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


    // Checking if the Email is already in use

    @GetMapping("/{email}")
    public ResponseEntity<Message> checkEmail(@PathVariable String email){
        if (userService.findUserByEmail(email).isPresent()){
            return new ResponseEntity<>(new Message(new Data("Email already in use")), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new Message(new Data("Good for use" )), HttpStatus.CREATED);
    }

}
