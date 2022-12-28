package com.Priemier.UserMicroservice.dao;

import com.Priemier.UserMicroservice.model.AccountUser;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AccountUser, Integer> {
}
