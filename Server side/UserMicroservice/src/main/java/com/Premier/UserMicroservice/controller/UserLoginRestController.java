package com.Premier.UserMicroservice.controller;


import com.Premier.UserMicroservice.Data;
import com.Premier.UserMicroservice.Message;
import com.Premier.UserMicroservice.model.User;
import com.Premier.UserMicroservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin()
public class UserLoginRestController {
    private static Logger logger = LoggerFactory.getLogger(UserLoginRestController.class);
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Message> loginUser(@RequestBody User user) {
        Optional<User> user1 = userService.findUserByUsernameContaining(user.getUsername());
        if(!user1.isPresent()){
            return new ResponseEntity(new Message(new Data("Username is not available")), HttpStatus.NOT_FOUND);
        }
        if(!user.getPassword().equals(user1.get().getPassword()) ){
            logger.info(user.getPassword() + "  " + user1.get().getPassword());
            return new ResponseEntity(new Message( new Data("Password is Incorrect")),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new Message(new Data("SuccessFully Logged In")), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getUserList();
    }
}
