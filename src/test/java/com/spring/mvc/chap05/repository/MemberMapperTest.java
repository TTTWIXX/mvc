package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Test
    @DisplayName("회원가입에 성공해야 한다.")
    void registerTest() {
        Member member = Member.builder()
                .account("peach")
                .password("ppp1234")
                .name("천도복숭아")
                .email("peach@naver.com")
                .build();

        boolean flag = memberMapper.save(member);
        assertTrue(flag);

    }
    @Test
    @DisplayName("peach 라는 계정명으로 회원을 조회하면" +
            " 그 회원의 이름이 천도복숭아여야 한다.")
    void findMemberTest() {
        //given
        String acc = "peach";

        //when
        Member foundMember = memberMapper.findMember(acc);

        //then
        System.out.println("foundMember = " + foundMember);
        assertEquals("천도복숭아", foundMember.getName());
    }

    @Test
    @DisplayName("계정명이 peach 인 경우 결과값이 1이 나와야 한다.")
    void accountDuplicateTest() {
        // given
        String acc = "peach";

        //when
        int count = memberMapper.isDuplicate("account", acc);

        //then
        assertEquals(1, count);
    }
}