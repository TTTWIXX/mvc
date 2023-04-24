package com.spring.mvc.test_spring.Entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TestBoard {
    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDateTime; // 작성일자시간
}
