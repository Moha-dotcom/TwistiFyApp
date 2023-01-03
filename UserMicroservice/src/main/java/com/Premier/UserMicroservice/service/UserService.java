package com.Premier.UserMicroservice.service;

import com.Premier.UserMicroservice.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findUserByUsernameContaining(String username);
    List<User> getUserList();

//    void delete(String username);
    User save(User user);

    Optional<User> findById(String userId);
}