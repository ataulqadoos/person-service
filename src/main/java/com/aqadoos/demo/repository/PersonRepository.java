package com.aqadoos.demo.repository;

import com.aqadoos.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstName(String firstName);
    Optional<Person> findByLastName(String lastName);

}
