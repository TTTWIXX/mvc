package com.spring.mvc.spring_jdbc;

import com.spring.mvc.jdbc.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class PersonSpringRepositoryTest {

    @Autowired
    PersonSpringRepository repository;
    @Test
    void savePersonTest(){
        Person p=new Person();
        p.setPersonName("김스프링");
        p.setPersonAge(2);

        repository.savePerson(p);

    }
    @Test
    void updatePersonTest(){
        Person p=new Person();
        p.setId(1L);
        p.setPersonName("히히");
        p.setPersonAge(1515);

        boolean flag = repository.modify(p);
    }

}