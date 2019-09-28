package com.aqadoos.demo.service;

import com.aqadoos.demo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testFindAll() {
        assertThat(this.personService).isNotNull();

        List<Person> result = this.personService.findAll();
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void testFindByFirstName() {
        assertThat(this.personService).isNotNull();

        String firstName = "Bruce";
        Person result = this.personService.findByFirstName(firstName);
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void testFindByLastName() {
        assertThat(this.personService).isNotNull();

        String lastName = "Doe";
        Person result = this.personService.findByLastName(lastName);
        assertThat(result).isNotNull();
        assertThat(result.getLastName()).isEqualTo(lastName);
    }
}
