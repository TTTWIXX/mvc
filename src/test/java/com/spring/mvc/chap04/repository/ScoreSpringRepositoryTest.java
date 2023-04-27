package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class ScoreSpringRepositoryTest {
    @Autowired
    ScoreSpringRepository scoreSpringRepository;

    @Test
    void saveTest(){
        Score s=new Score();
        scoreSpringRepository.save(s);


    }
    @Test
    void removeTest(){
        int stuNum=1;
        scoreSpringRepository.deleteByStuNum(stuNum);

    }


}