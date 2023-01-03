package com.Premier.UserMicroservice.dao;

import com.Premier.UserMicroservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User>  findByUserId(String id);

    User findByUsername(String username);


}
