package com.spring.mvc.test_spring.dto;

import com.spring.mvc.test_spring.Entity.TestBoard;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.format.DateTimeFormatter;


@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class TestBoardListResponseDTO {
    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private String regDateTime; // 작성일자시간

    public TestBoardListResponseDTO(TestBoard testBoard) {
        this.boardNo = testBoard.getBoardNo();
        this.title = shortTitle(testBoard);
        this.content = shortContent(testBoard);
        this.viewCount=testBoard.getViewCount();
        this.regDateTime = patteredDate(testBoard);
    }

    private String patteredDate(TestBoard testBoard) {
       DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

      return pattern.format(testBoard.getRegDateTime());

    }

    private String shortContent(TestBoard testBoard) {
        String oriContent = testBoard.getContent();
        return (oriContent.length() > 30) ? oriContent.substring(0, 30) + "..." : oriContent;
    }

    private String shortTitle(TestBoard testBoard) {
        String oriTitle = testBoard.getTitle();
        return (oriTitle.length() > 8) ? oriTitle.substring(0, 8) + "..." : oriTitle;
    }
}
