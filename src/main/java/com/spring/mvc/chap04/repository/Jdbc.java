package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc {
    private String url = "jdbc:mariadb://localhost:3307/spring";
    private String username = "root";
    private String password = "1234";

    public Jdbc() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 저장기능
    public void save(Score score) {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            String sql = "insert into score values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,score.getName());
            pstmt.setInt(2,score.getKor());
            pstmt.setInt(3,score.getEng());
            pstmt.setInt(4,score.getMath());
            pstmt.setInt(5,score.getStuNum());
            pstmt.setString(6,score.getGrade().toString());

            int n = pstmt.executeUpdate();
            if (n == 1) conn.commit();
            else conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


        }


    }

}
