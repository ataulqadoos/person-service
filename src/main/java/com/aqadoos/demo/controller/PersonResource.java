package com.aqadoos.demo.controller;

import com.aqadoos.demo.domain.Person;
import com.aqadoos.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    @GetMapping("/firstname/{name}")
    public Person findByFirstName(@PathVariable String name) {
        return this.personService.findByFirstName(name);
    }

    @GetMapping("/lastname/{name}")
    public Person findByLastName(@PathVariable String name) {
        return this.personService.findByLastName(name);
    }
}
