package com.ucb.tunehubapp.sysarch.service.impl;

import com.ucb.tunehubapp.sysarch.api.model.Person;
import com.ucb.tunehubapp.sysarch.dto.PersonDTO;
import com.ucb.tunehubapp.sysarch.repo.PersonRepo;
import com.ucb.tunehubapp.sysarch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepository;


    @Override
    public String addPerson(PersonDTO personDTO) {
        if (personExists(personDTO.getEmail())) {
            return "user already exists";
        }

        Person person = new Person(
                personDTO.getName(),
                personDTO.getEmail()
        );
        personRepository.save(person);
        return person.getName();
    }

    @Override
    public Optional<Person> getPerson(String name, String email, String password) {
        Optional<Person> person = personRepository.findByNameAndEmail(name, email);
        if (person.isPresent() && password.matches(password)) {
            return person;
        }
        return Optional.empty();
    }

    @Override
    public boolean personExists(String email) {
        return personRepository.findByEmail(email).isPresent();
    }
}