package com.Priemier.UserMicroservice.dao;

import com.Priemier.UserMicroservice.model.AccountUser;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<AccountUser, ObjectId> {
}
