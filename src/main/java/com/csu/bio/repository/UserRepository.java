package com.csu.bio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csu.bio.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
}
