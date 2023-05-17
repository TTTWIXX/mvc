package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.request.LoginRequestDTO;
import com.spring.mvc.chap05.dto.request.SignUpRequestDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("SingUpDTO를 전달하면 회원가입에 성공해야 한다.")
    void joinTest(){
        //given
        SignUpRequestDTO dto = new SignUpRequestDTO();
        dto.setAccount("abcd1234");
        dto.setPassword("1234");
        dto.setName("rnrnrn1234");
        dto.setEmail("1231234@1234");

        // when
        memberService.join(dto);
    }

    @Test
    @DisplayName("계정명이 1234인 회원의 로그인시도 결과 검증을 상황별로 수행해야 한다.")
    void loginTest(){
        //given
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setAccount("1234");
        dto.setPassword("1234!");

        //when
        LoginResult result = memberService.authenticate(dto);

        //then
        assertEquals(LoginResult.SUCCESS, result);

    }

}