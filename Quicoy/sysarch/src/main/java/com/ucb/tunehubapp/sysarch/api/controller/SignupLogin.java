package com.ucb.tunehubapp.sysarch.api.controller;

import com.ucb.tunehubapp.sysarch.api.Response;
import com.ucb.tunehubapp.sysarch.api.model.Login;
import com.ucb.tunehubapp.sysarch.api.model.Person;
import com.ucb.tunehubapp.sysarch.dto.PersonDTO;
import com.ucb.tunehubapp.sysarch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping
public class SignupLogin {

    @Autowired
    private PersonService personService;


    @PostMapping("/SignUp")
    public ResponseEntity<Response> SignUp(@RequestBody PersonDTO personDTO) {
        if (personService.personExists(personDTO.getEmail())) {
            Response response = new Response("User already exists", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        String id = personService.addPerson(personDTO);
        if (id != null) {
            Response response = new Response("User successfully registered", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Response response = new Response("User registration failed", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<Response> Login(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            Response response = new Response("Either of the parameters is null or empty", null);
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Person> person = personService.getPerson(name, email, password);
        if (person.isPresent()) {
            Response response = new Response("Login successful", person.get());
            return ResponseEntity.ok(response);
        } else {
            Response response = new Response("Invalid email or password", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


//    @PostMapping(path = "/save")
//    public String savePerson(@RequestBody PersonDTO personDTO) {
//
//    String id = personService.addPerson(personDTO);
//    return id;
//    }
//    @PostMapping("/signup")
//    public ResponseEntity<String> savePerson(@RequestParam String name,@RequestParam String email,@RequestParam String password) {
//        String registrationMessage = personService.registerUser(user.getUsername(), user.getPassword());
//
//        Map<String, String> response = new HashMap<>();
//        if (registrationMessage.equals("user already exists")) {
//            response.put("error", registrationMessage);
//            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
//        } else if (registrationMessage.equals("successful registration")) {
//            response.put("message", registrationMessage);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        } else {
//            response.put("error", registrationMessage);
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
}
