package com.ucb.tunehubapp.sysarch.service;

import com.ucb.tunehubapp.sysarch.api.model.Campspot;
import com.ucb.tunehubapp.sysarch.api.model.Person;
import com.ucb.tunehubapp.sysarch.dto.CampspotDTO;
import com.ucb.tunehubapp.sysarch.dto.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface CampspotService {
    String addCampspot(CampspotDTO campspotDTO);
    List<Campspot> getAllCampspots();


    List<Campspot> findBybLocation(String bLocation);

    Campspot saveCampspot(Campspot campspot);

    boolean campspotExists(String aCampname);

     Optional <Campspot> getCampspotByaCampName(String aCampName);
    boolean campnameExists(String aCampName);

    Optional<Campspot> getCampspotByCampName(String aCampName);
}
