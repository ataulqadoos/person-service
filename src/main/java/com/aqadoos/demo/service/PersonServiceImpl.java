package com.aqadoos.demo.service;

import com.aqadoos.demo.domain.Person;
import com.aqadoos.demo.repository.PersonRepository;
import com.aqadoos.demo.service.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findByFirstName(String firstName) {
        Optional<Person> person = this.personRepository.findByFirstName(firstName);

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("Person with firstName: " + firstName + " not found.");
        }
    }

    @Override
    public Person findByLastName(String lastName) {
        Optional<Person> person = this.personRepository.findByLastName(lastName);

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("Person with lastName: " + lastName + " not found.");
        }
    }
}
