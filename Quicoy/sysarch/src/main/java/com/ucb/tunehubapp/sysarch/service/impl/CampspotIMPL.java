package com.ucb.tunehubapp.sysarch.service.impl;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ucb.tunehubapp.sysarch.api.model.Campspot;
import com.ucb.tunehubapp.sysarch.dto.CampspotDTO;
import com.ucb.tunehubapp.sysarch.repo.CampspotRepo;
import com.ucb.tunehubapp.sysarch.service.CampspotService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class CampspotIMPL implements CampspotService {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter ;

    @Autowired
    private CampspotRepo campspotRepo;


    @Override
    public String addCampspot(CampspotDTO campspotDTO) {
        if (campnameExists(campspotDTO.getaCampName())) {
            return "Camp already exists";
        }

        Campspot campspot = new Campspot(
                campspotDTO.getaCampName(),
                campspotDTO.getbLocation(),
                campspotDTO.getcAmenities(),
                campspotDTO.getdActivities(),
                campspotDTO.geteAccomodation(),
                campspotDTO.getfAccessibilities(),
                campspotDTO.gethTransportation(),
                campspotDTO.getgNetwork()
                );
        campspotRepo.save(campspot);
        return campspot.getaCampName();
    }

    @Override
    public List<Campspot> getAllCampspots() {
        return List.of();
    }

    @Override
    public List<Campspot> findBybLocation(String bLocation) {
        final List<Campspot> campspots =new ArrayList<>();

        MongoDatabase database = client.getDatabase("Sysarch");
        MongoCollection<Document> collection = database.getCollection("campspot");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList());

        result.forEach(doc -> campspots.add(converter.read(Campspot.class, doc)));

        return campspots;
    }

    @Override
    public Campspot saveCampspot(Campspot campspot) {
        return null;
    }

    @Override
    public boolean campspotExists(String campspotName) {
        return false;
    }

    @Override
    public boolean campnameExists(String aCampName) {
        return campspotRepo.findByaCampName(aCampName).isPresent();
    }

    @Override
    public Optional<Campspot> getCampspotByaCampName(String aCampName) {
        return Optional.of(campspotRepo.findByaCampName(aCampName).get());
    }
    @Override
    public Optional<Campspot> getCampspotByCampName(String acampName) {
        return CampspotRepo.findByCampName(acampName);
    }

}
