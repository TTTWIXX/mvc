package com.spring.mvc.test_spring.controller;

import com.spring.mvc.test_spring.dto.TestBoardListResponseDTO;
import com.spring.mvc.test_spring.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@RequestMapping("/test")
@Controller
@AllArgsConstructor
public class TestController {
    private final TestService testService;


    // 메인화면을 보여줌
    @GetMapping("/list")
    public String showList(Model model){
        System.out.println("/test/list : get");
        TestBoardListResponseDTO dto=new TestBoardListResponseDTO();
        testService.findAllList();

        return "/chap05/list";
    }

    //





}
