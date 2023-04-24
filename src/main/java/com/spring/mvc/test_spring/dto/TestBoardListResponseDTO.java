package com.spring.mvc.test_spring.dto;

import com.spring.mvc.test_spring.Entity.TestBoard;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@ToString
@EqualsAndHashCode
public class TestBoardListResponseDTO {
    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDateTime; // 작성일자시간

    public TestBoardListResponseDTO(TestBoard board) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.regDateTime = regDateTime;
    }
}
