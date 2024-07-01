package com.ucb.tunehubapp.sysarch.service;

import com.ucb.tunehubapp.sysarch.api.Response;
import com.ucb.tunehubapp.sysarch.api.model.Login;
import com.ucb.tunehubapp.sysarch.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class LoginService {


    private List<Login> loginList;

    public LoginService(){
        loginList = new ArrayList<>();

        Login login1 = new Login("Joem@gmail.com", "123456");
        Login login2 = new Login("Hans@gmail.com", "123456");
        Login login3 = new Login("Sean@gmail.com", "123456");
        Login login4 = new Login("Kean@gmail.com", "123456");
        Login login5 = new Login("John@gmail.com", "123456");

        loginList.addAll(Arrays.asList(login1, login2, login3, login4, login5));


    }

    public Optional<Login> getLogin(String email, String password){
        Optional optional = Optional.empty();
        for (Login login:loginList){
            if (email == login.getEmail()){
                optional = Optional.of(login);
                return optional;
            }
        }
        return optional;

    }

//    public Response signUp(SignUpRequest signUpRequest) {
//        Response response = new Response();
//        return response;
//    }
}
