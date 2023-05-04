package com.spring.mvc.chap05.dto.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter @ToString
public class Search extends Page {
    // 찾으려면 페이지의 정보가 필요하다!!
    // 검색을 하려면 페이지의 정보가 필요?
    // 페이지를 보려면 검색을 해야하나? 로 생각해보자

    // 검색 타입, 검색 키워드
    private String type;
    private String keyword;

    public Search() {
        this.type = "";
        this.keyword = "";
    }
}
