package com.aqadoos.demo.repository;

import com.aqadoos.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRespositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository repository;

    @Test
    public void testFindAll() {
        assertThat(this.repository).isNotNull();

        List<Person> result = this.repository.findAll();
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void testFindByFirstName() {
        assertThat(this.repository).isNotNull();

        String firstName = "Bruce";
        Person result = this.repository.findByFirstName(firstName).orElse(null);
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void testFindByLastName() {
        assertThat(this.repository).isNotNull();

        String lastName = "Doe";
        Person result = this.repository.findByLastName(lastName).orElse(null);
        assertThat(result).isNotNull();
        assertThat(result.getLastName()).isEqualTo(lastName);
    }
}
