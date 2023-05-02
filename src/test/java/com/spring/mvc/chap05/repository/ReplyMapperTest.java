package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.dto.page.Page;
import com.spring.mvc.chap05.dto.page.Search;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {
    @Autowired
    BoardMapper boardMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("게시물 300개를 등록하고 각 게시물에 랜덤으로 1000개의 댓글을 나눠서 등록해야 한다.")
    void bulkInsertTest() {
//        for(int i=1;i<=300;i++){
//            Board b = Board.builder()
//            .title("재밌는 게시물" + i)
//            .content("노잼 게시물 내용" + i).build();

//            boardMapper.save(b);
//        }
//        assertEquals(300,boardMapper.count(new Search()));

//        for(int i=1;i<=1000;i++){
//            Reply r = Reply.builder()
//            .replyWriter("잼민이" + i)
//            .replyText("말똥이~~~" + i)
//            .boardNo((long) (Math.random() * 300 + 1))
//            .build();

//            replyMapper.save(r);
//        }


    }

    @Test
    @DisplayName("댓을을 3번 게시물에 등록하면 3번 게시물의 총 댓글 수는 몇개?")
    @Transactional
    @Rollback
        // 테스트 끝난 이후 롤백해라
    void saveTest() {
        //given
        long boardNo = 3L;
        Reply newReply = Reply.builder()
                .replyText(("세이브세이브"))
                .replyWriter("긴또깡")
                .boardNo(boardNo)
                .build();

        //when
        boolean flag = replyMapper.save(newReply);

        //then
        assertTrue(flag);
        assertEquals(8, replyMapper.count(boardNo));


    }

    @Test
    @DisplayName("댓글 번호가 1001번인 댓글을 삭제하면 " +
            "3번 게시물의 총 댓글 수가 3이어야 한다.")
    @Transactional
    @Rollback
    void removeTest() {
        //given
        long replyNo = 1001L;
        long boardNo = 3L;

        //when
        boolean flag = replyMapper.deleteOne(replyNo);

        //then
        assertTrue(flag);
        assertEquals(7, replyMapper.count(boardNo));
    }

    @Test
    @DisplayName("댓글 번호가 5번인 댓을의 내용을 '5번댓글임' 으로 바꾼다.")
    @Transactional
    @Rollback
    void modifyTest() {
        //given
        long replyNo = 5L;
        Reply b = Reply.builder().replyText("5번댓글임").replyNo(replyNo).build();

        //when
        boolean m = replyMapper.modify(b);

        //then
        assertTrue(m);
        assertEquals(b.getReplyText(), "5번댓글임");
    }

    @Test
    @DisplayName("댓글번호가 5번인 댓글을 읽어 '말똥이~~~4'가 나와야 한다.")
    void selectOneTest() {

        //given
        long replyNo = 5L;

        //when
        Reply o = replyMapper.findOne(replyNo);

        //then
        assertEquals(o.getReplyText(), "말똥이~~~4");

    }

    @Test
    @DisplayName("1번게시물의 댓글을 전부 읽어 댓글의 갯수가 5개 여야 한다.")
    void selectAll() {
        //given
        long boardNo = 1L;
        Page p;

        //when
        List<Reply> all = replyMapper.findAll(boardNo, new Page());

        //then
        assertEquals(all.size(), 5);


    }


}