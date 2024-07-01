package com.ucb.tunehubapp.sysarch.repo;

import com.ucb.tunehubapp.sysarch.api.model.Campspot;
import com.ucb.tunehubapp.sysarch.api.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
import java.util.Optional;
@EnableMongoRepositories
public interface CampspotRepo extends MongoRepository<Campspot, String> {
    static
    Optional<Campspot> findByCampName(String acampName) {
        return Optional.empty();
    }

    List<Campspot> findByBLocation(String bLocation);
        Optional<Campspot> findByaCampName(String aCampName);

//        List<Campspot> findByName(String aCampName);

    Campspot getCampspotByaCampName(String aCampName);
}

