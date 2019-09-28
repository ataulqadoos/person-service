package com.aqadoos.demo.service;

import com.aqadoos.demo.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findByFirstName(String firstName);
    Person findByLastName(String lastName);
}
