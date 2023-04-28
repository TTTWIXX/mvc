package com.spring.mvc.chap05.dto;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BoardUpdateRequestDTO {
    private int boardNo;
    private String title;
    private String content;

}
