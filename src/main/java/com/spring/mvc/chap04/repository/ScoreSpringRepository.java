package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("SpringJdbc")
@RequiredArgsConstructor
public class ScoreSpringRepository implements ScoreRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public List<Score> findAll(String sort) {
        return ScoreRepository.super.findAll(sort);
    }

    @Override
    public boolean save(Score score) {
        String sql = "insert into score values(?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, score.getStuNum(), score.getKor(), score.getEng(), score.getMath(), score.getTotal(), String.valueOf(score.getGrade()));
        if (update == 1) {
            return true;
        } else
            return false;

    }

    @Override
    public boolean deleteByStuNum(int stuNum) {
        return false;
    }

    @Override
    public Score findByStuNum(int stuNum) {
        return null;
    }
}
