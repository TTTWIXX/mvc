package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("spring")
@RequiredArgsConstructor
public class ScoreSpringRepository implements ScoreRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public List<Score> findAll(String sort) {
        String sql = "select * from tbl_score ";
        switch (sort) {
            case "num":
                sql += " ORDER BY stu_num";
                break;
            case "name":
                sql += " ORDER BY stu_name";
                break;
            case "avg":
                sql += " ORDER BY average DESC";
                break;
        }


        return jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });

    }

    @Override
    public boolean save(Score score) {
        String sql = "insert into tbl_score values(?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, score.getName(), score.getKor(), score.getEng(),
                score.getMath(), score.getStuNum(), score.getTotal(),
                score.getAverage(), String.valueOf(score.getGrade()));
        if (update == 1) {
            return true;
        } else
            return false;

    }

    @Override
    public boolean deleteByStuNum(int stuNum) {
        String sql = "delete from tbl_score where stu_num=?";
        int result = jdbcTemplate.update(sql, stuNum);
        return result == 1;
    }

    @Override
    public Score findByStuNum(int stuNum) {
        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";
        return jdbcTemplate.queryForObject(sql,
                (rs , n) -> new Score(rs)
                , stuNum
        );


    }
}
