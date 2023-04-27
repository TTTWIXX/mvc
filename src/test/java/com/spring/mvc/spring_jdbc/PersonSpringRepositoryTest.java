package com.spring.mvc.spring_jdbc;

import com.spring.mvc.jdbc.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonSpringRepositoryTest {

    @Autowired
    PersonSpringRepository repository;
    @Test
    void savePersonTest(){
        Person p=new Person()   ;
        p.setPersonName("kimspring");
        p.setPersonAge(2);
        repository.savePerson(p);
    }
    @Test
    void modifyPersonTest() {
        // given
        Person p = new Person();
        p.setId(2L);
        p.setPersonName("LEE");
        p.setPersonAge(100);
        // when
        boolean flag = repository.modify(p);
        // then
        Assertions.assertTrue(flag);
    }
    @Test
    void removeTest(){
        long id=1L;
        repository.removePerson(id);
    }

}