package com.ucb.tunehubapp.sysarch.api.controller;

import com.ucb.tunehubapp.sysarch.api.Response;
import com.ucb.tunehubapp.sysarch.api.model.Campspot;
import com.ucb.tunehubapp.sysarch.dto.CampspotDTO;
import com.ucb.tunehubapp.sysarch.dto.PersonDTO;
import com.ucb.tunehubapp.sysarch.repo.CampspotRepo;
import com.ucb.tunehubapp.sysarch.service.CampspotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class CampspotController {
    @Autowired
private CampspotService campspotService;
    @Autowired
    private CampspotRepo campspotRepo;


    @PostMapping("/AddCampsite")
    public ResponseEntity<Response> SignUp(@RequestBody CampspotDTO campspotDTO) {
        if (campspotService.campspotExists(campspotDTO.getaCampName())) {
            Response response = new Response("Camp already exists", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        String campname = campspotService.addCampspot(campspotDTO);
        if (campname != null) {
            Response response = new Response("Campsite successfully registered", campname);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Response response = new Response("Camsitefailed", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/getcampspot")
    public List<Campspot> getAllCampspots() {

        return campspotRepo.findAll();
    }


    @GetMapping("/getcampName")

//    public List<Campspot> getCampname(@PathVariable String bLocation) {
//        return campspotRepo.findByBLocation(bLocation);
//    }

//
//    public ResponseEntity<Campspot> getCampname(@PathVariable String aCampName) {
//        Optional<Campspot> campspot = campspotService.getCampspotByaCampName(aCampName);
//        return campspot.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//
//    }

    public ResponseEntity<Campspot> getCampspotByCampName(@PathVariable String aCampName) {
        Optional<Campspot> campspot = campspotService.getCampspotByCampName(aCampName);
        return campspot.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

