package com.Priemier.UserMicroservice.Controller;


import com.Priemier.UserMicroservice.Message;
import com.Priemier.UserMicroservice.model.AccountUser;
import com.Priemier.UserMicroservice.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {
    @Autowired
    UserService userservice;

    @GetMapping("/users")
    @CrossOrigin()
    private List<AccountUser> getAllUser(){
        return userservice.getAllUser();
    }
    @GetMapping("/users/{id}")
    @CrossOrigin()
    private AccountUser getUser(@RequestParam ObjectId userid){
        return userservice.getUser(userid);
    }
    @PostMapping("/users")
    @CrossOrigin()
    private Message createUser(@RequestBody AccountUser accountUser){
        return userservice.createUser(accountUser);
    }

//    @PutMapping("/users")
//    public Message UpdateAccountUser(AccountUser user, int userId){
//        return new Message("Deleteing User", LocalDate.now());
//    }
//    @DeleteMapping("/users")
//    private Message deleteUser(){
//            return new Message("Deleteing User", LocalDate.now());
//    }
}
