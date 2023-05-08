package com.spring.mvc.chap05.dto.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TestPage {
    // 한 페이지에 존재하는 게시글 수
    private int amount;

    // 클라이언트가 보낸 page번호
    private int pageNo;

    public TestPage() {
        this.pageNo = 1;
        this.amount = 5;
    }

    public void setAmount(int amount) {
        if (amount < 0 || amount > 10) {
            this.amount = 6;
            return;
        }
        this.amount = amount;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 0 || pageNo > Integer.MAX_VALUE) {
            this.pageNo = 1;
            return;
        }
        this.pageNo=pageNo;
    }
}
