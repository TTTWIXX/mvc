package com.spring.mvc.test_spring.controller;

import com.spring.mvc.test_spring.dto.TestBoardListResponseDTO;
import com.spring.mvc.test_spring.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.List;

@RequestMapping("/test")
@Controller
@AllArgsConstructor
public class TestController {
    private final TestService testService;


    // 메인화면을 보여줌
    @GetMapping("/list")
    public String showList(Model model){
        System.out.println("/test/list : get");
        List<TestBoardListResponseDTO> allList = testService.findAllList();
//        for (TestBoardListResponseDTO testBoardListResponseDTO : allList) {
//            System.out.println("testBoardListResponseDTO = " + testBoardListResponseDTO);
//        }
        model.addAttribute("sList",allList);
        return "chap05/list";
    }

    //





}
