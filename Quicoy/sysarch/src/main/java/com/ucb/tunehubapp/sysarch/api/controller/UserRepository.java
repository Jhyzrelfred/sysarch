package com.ucb.tunehubapp.sysarch.api.controller;
import com.ucb.tunehubapp.sysarch.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}