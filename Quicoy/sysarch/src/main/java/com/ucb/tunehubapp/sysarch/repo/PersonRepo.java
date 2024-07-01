package com.ucb.tunehubapp.sysarch.repo;

import com.ucb.tunehubapp.sysarch.api.model.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface PersonRepo extends MongoRepository<Person, Integer> {
    Optional<Person> findByNameAndEmail(String name, String email);
    Optional<Person> findByEmail(String email);
    Optional<Person> findByName(String name);
}
//public interface PersonRepo{}