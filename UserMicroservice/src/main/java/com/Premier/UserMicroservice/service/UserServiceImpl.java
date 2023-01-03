package com.Premier.UserMicroservice.service;

import com.Premier.UserMicroservice.dao.UserRepository;
import com.Premier.UserMicroservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByUsernameContaining(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }



    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String userId) {
        return userRepository.findByUserId(userId);
    }
}


