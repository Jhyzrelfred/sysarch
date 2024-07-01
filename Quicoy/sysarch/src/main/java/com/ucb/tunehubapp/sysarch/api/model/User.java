package com.ucb.tunehubapp.sysarch.api.model;


import org.springframework.data.mongodb.core.mapping.Document;



public class User {
    private int id;
    private String name;
    private int age;
    private String email;


    public User(int id, String name, int age, String email){

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public int getId(){
        return id;
    }
    public void SetId(int id){
        this.id= id;
    }
    public String getName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void SetAge(int age){
        this.age= age;
    }
    public String getEmail(){
        return email;
    }
    public void SetEmail(String email){
        this.email= email;
    }


}
