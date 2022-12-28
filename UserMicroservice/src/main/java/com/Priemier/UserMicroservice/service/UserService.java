package com.Priemier.UserMicroservice.service;

import com.Priemier.UserMicroservice.Message;
import com.Priemier.UserMicroservice.dao.UserRepository;
import com.Priemier.UserMicroservice.model.AccountUser;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    // Get All Users
    public List<AccountUser> getAllUser(){
        return userRepository.findAll();
    }

    // Get one User
    public AccountUser getUser(ObjectId id){
//        AccountUser returnedUser = new AccountUser();
        return userRepository.findById(id).get();
    }
    // Create a User
    public Message createUser(AccountUser user){
        AccountUser newUser = new AccountUser();
        newUser.setUserId(new ObjectId());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<AccountUser> user1 = userRepository.findById(newUser.getUserId());
        if(user1.isPresent()){
            return new Message( "UserAccount Exists", LocalDate.now());
        }else {

           userRepository.save(newUser);
           return new Message( "Your Account is created SuccessFully", LocalDate.now());
        }
    }
    // Update User
//    public Message UpdateAccountUser(AccountUser user, UUID userId){
//        Optional<AccountUser> users = userRepository.findById(userId);
//       if(users.isPresent()){
//          AccountUser user1 = new AccountUser();
//          user1.setEmail(user.getEmail());
//          user1.setPassword(user.getPassword());
//          userRepository.save(user1);
//          return new Message("SuccessFully Saved user", LocalDate.now());
//       }else{
//           return new Message("User doesn't Exist Please Create a new Account", LocalDate.now());
//       }
//    }
//    // Delete User
//    public Message deleteAccountUser(UUID userId){
//        AccountUser userFound = getUser(userId);
//        Optional<AccountUser> user1 = userRepository.findById(userId);
//        if(user1.isPresent()){
//            userRepository.delete(userFound);
//            return new Message("SuccessFully Deleted user", LocalDate.now());
//        }else{
//            return new Message("User doesn't Exist", LocalDate.now());
//        }
//    }
}
