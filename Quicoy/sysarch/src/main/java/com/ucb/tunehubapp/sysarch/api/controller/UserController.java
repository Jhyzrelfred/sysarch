package com.ucb.tunehubapp.sysarch.api.controller;


import com.ucb.tunehubapp.sysarch.api.Response;
import com.ucb.tunehubapp.sysarch.api.model.Login;
import com.ucb.tunehubapp.sysarch.api.model.User;
import com.ucb.tunehubapp.sysarch.dto.PersonDTO;
import com.ucb.tunehubapp.sysarch.service.LoginService;
import com.ucb.tunehubapp.sysarch.service.PersonService;
import com.ucb.tunehubapp.sysarch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private LoginService loginService;

    @Autowired
    private PersonService personService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/login")
    public ResponseEntity<Response> getLogin(@RequestParam String email, @RequestParam String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            Response response = new Response("Either of the parameters is null or empty", null);
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Login> login = loginService.getLogin(email, password);
        if (login.isPresent()) {
            Response response = new Response("Login successful", login.get());
            return ResponseEntity.ok(response);
        } else {
            Response response = new Response("Invalid email or password", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

//    @PostMapping(path = "/save")
//    public String savePerson(@RequestBody PersonDTO personDTO) {
//
//        String id = personService.addPerson(personDTO);
//        return id;
//    }

//    @PostMapping("/signup")
//    public ResponseEntity<Response> SignUp(@RequestBody SignUp signUpRequest) {
//        String email = signUpRequest.getEmail();
//        String password = signUpRequest.getPassword();
//
//        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
//            Response response = new Response("Either of the parameters is null or empty", null);
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        if (userService.userExists(email)) {
//            Response response = new Response("User already exists with this email", null);
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
//        }
//
//        User newUser = userService.createUser(email, password);
//        Response response = new Response("Sign up successful", newUser);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }



    private UserService userService;


    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
}
