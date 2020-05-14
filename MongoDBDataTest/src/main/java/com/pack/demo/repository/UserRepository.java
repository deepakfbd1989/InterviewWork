package com.pack.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pack.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

}
