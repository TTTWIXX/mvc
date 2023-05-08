package com.spring.mvc.chap05.dto.page;

import lombok.*;

@Getter
@ToString
public class TestPageMaker {

    // 보여지는 목록 개수
    private static final int PAGE_COUNT=5;

    // 목록 시작값, 목록 끝나는 값
    private int begin,end,finalPage;

    //이전, 다음 버튼 활성화
    private boolean prev,next;

    //현재 요청 page 정보
    private Page page;

    //총 게시물 수
    private int totalCount;


    public TestPageMaker(TestPage testPage){
        //현재 P
        this.end=(int)Math.ceil(testPage.getPageNo()/(double)PAGE_COUNT)*PAGE_COUNT;

        this.begin=end-PAGE_COUNT+1;

        this.finalPage=(int)Math.ceil(totalCount/(double)testPage.getAmount());

        if(finalPage<end)
            this.end=finalPage;

        this.prev=begin>1;
        this.next=end<this.finalPage;


    }


}
