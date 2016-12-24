package com.csu.bio.frame.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csu.bio.object.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
}
