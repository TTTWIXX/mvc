package com.spring.mvc.testmvc.dto;

import com.spring.mvc.testmvc.entity.TestBoard;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class TestReponseDTO {


    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private String regDateTime; // 작성일자시간


    public TestReponseDTO(TestBoard testBoard) {
        this.boardNo = testBoard.getBoardNo();
        this.title = shortTitle(testBoard.getTitle());
        this.content = shortContent(testBoard.getContent());
        this.regDateTime = shortDateTime(testBoard.getRegDateTime());
    }

//    static String makePrettierDateString(LocalDateTime regDateTime) {
//        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        return pattern.format(regDateTime);
//    }

    private String shortDateTime(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private String shortContent(String content) {
        return (title.length() > 30) ? content.substring(0, 30) + "..." : content;
    }

    private String shortTitle(String title) {
        return (title.length() > 8) ? title.substring(0, 8) + "..." : title;

    }
}
}
