package com.spring.mvc.test_spring.Repository;

import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.test_spring.Entity.TestBoard;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TestRepository implements TestBoardRepository{

    private static Map<Integer,TestBoard> mapList;
    static  int  sequence;
    static {
        sequence=0;
        mapList=new HashMap<>();
        TestBoard ex1=new TestBoard(++sequence,"제목1","내용1", LocalDateTime.now());
        TestBoard ex2=new TestBoard(++sequence,"제목2","내용2", LocalDateTime.now());
        TestBoard ex3=new TestBoard(++sequence,"제목3","내용3", LocalDateTime.now());
        mapList.put(ex1.getBoardNo(),ex1);
        mapList.put(ex2.getBoardNo(),ex2);
        mapList.put(ex3.getBoardNo(),ex3);

    }


    @Override
    public List<TestBoard> findAll() {
        return mapList.values().stream()
                .sorted(Comparator.comparing((TestBoard d)->d.getBoardNo())
                        .reversed()).collect(Collectors.toList());
    }

    @Override
    public TestBoard findOne(int boardNo) {
        return null;
    }

    @Override
    public boolean save(TestBoard testboard) {
        return false;
    }

    @Override
    public boolean deleteByNo(int boardNo) {
        return false;
    }
}
