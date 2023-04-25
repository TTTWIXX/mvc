package com.spring.mvc.test_spring.Repository;

import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.test_spring.Entity.TestBoard;

import java.util.List;

public interface TestBoardRepository {

    // 게시물 목록 조회
    List<TestBoard> findAll();

    // 게시물 상세 조회
    TestBoard findOne(int boardNo);

    // 게시물 등록
    boolean save(TestBoard testBoard);

    // 게시물 삭제
    boolean deleteByNo(int boardNo);

}
