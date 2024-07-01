package com.ucb.tunehubapp.sysarch.api.model;

public class Login {
    private String email;
    private String password;


    public Login(String email,String password){

        this.email = email;
        this.password = password;
    }

    public String getPassword(){

        return password;
    }
    public void SetPassword(String password){

        this.password = password;
    }
    public String getEmail(){

        return email;
    }
    public void SetEmail(String email){

        this.email= email;
    }
}
