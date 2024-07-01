package com.ucb.tunehubapp.sysarch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ucb.tunehubapp.sysarch.api.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1,"Joem", 32, "joem@gmail.com");
        User user2 = new User(2,"Sean", 24, "Sean@gmail.com");
        User user4 = new User(3,"Kean", 23, "Kean@gmail.com");
        User user5 = new User(4,"Shelb", 22, "Shelb@gmail.com");
        User user6 = new User(5,"Hans", 12, "Hans@gmail.com");

        userList.addAll(Arrays.asList(user1,user2,user2,user4,user5,user6));
    }

    public Optional<User> getUser(Integer id){
        Optional optional = Optional.empty();
        for (User user:userList){
            if (id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;

    }
}
