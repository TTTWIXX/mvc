package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ScoreMapperTest {
    @Autowired
    ScoreMapper scoreMapper;

    @Test
    void save() {
        Score score = Score.builder().name("이순신").eng(10).kor(20).math(30).stuNum(1).grade(Grade.F).build();
        boolean flag = scoreMapper.save(score);

        assertTrue(flag);
    }

    @Test
    void delete(){
        Score s = Score.builder().stuNum(1).build();
        int num=1;
        boolean b = scoreMapper.deleteByStuNum(num);
        assertTrue(b);

    }
    @Test
    void findAll(){
        String sort=null;
        List<Score> list=scoreMapper.findAll(sort);

        for (Score score : list) {
            System.out.println(score);
        }

        assertEquals(0,list.size());

    }
    @Test
    void findOne(){
        int stuNum=1;
        Score score = scoreMapper.findByStuNum(stuNum);
        System.out.println("score = " + score);
        assertEquals("이순신", score.getName());
    }

}