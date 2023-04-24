package com.spring.mvc.testmvc.repository;

import com.spring.mvc.testmvc.entity.TestBoard;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class TestRepository {

    public static Map<Integer, TestBoard> testBoardMap = new HashMap<Integer, TestBoard>();
    static int seqence = 0;

    static {
        TestBoard test1 = new TestBoard(++seqence, "이것이 제목인지라1", "이것이 내용인지라1", 1, LocalDateTime.now());
        TestBoard test2 = new TestBoard(++seqence, "이것이 제목인지라2", "이것이 내용인지라2", 1, LocalDateTime.now());
        TestBoard test3 = new TestBoard(++seqence, "이것이 제목인지라3", "이것이 내용인지라3", 1, LocalDateTime.now());
        testBoardMap.put(test1.getBoardNo(), test1);
        testBoardMap.put(test2.getBoardNo(), test2);
        testBoardMap.put(test3.getBoardNo(), test3);
    }


    public List<TestBoard> findAlll() {
        List<TestBoard> tb=new ArrayList<>();
        for (TestBoard testBoard : testBoardMap.values()) {
            tb.add(testBoard);
        }
        return tb;
    }
}
