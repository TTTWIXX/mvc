package com.spring.mvc.test_spring.controller;

import com.spring.mvc.test_spring.dto.TestRequestDTO;
import com.spring.mvc.test_spring.dto.TestBoardListResponseDTO;
import com.spring.mvc.test_spring.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/test")
@Controller
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;


    // 메인화면을 보여줌
    @GetMapping("/list")
    public String showList(Model model) {
        System.out.println("/test/list : get");
        List<TestBoardListResponseDTO> allList = testService.findAllList();
//        for (TestBoardListResponseDTO testBoardListResponseDTO : allList) {
//            System.out.println("testBoardListResponseDTO = " + testBoardListResponseDTO);
//        }
        model.addAttribute("bList", allList);
        return "testSpring/list";
    }

    //쓰기 화면을 보여줌
    @GetMapping("/write")
    public String writePage() {
        System.out.println("/test/write : get");
        return "testSpring/write";
    }

    //쓰기 화면의 정보를 가져와서 list 에서 보여주게 한다.
    @PostMapping
    public String writeInfo(TestRequestDTO dto, Model model) {
        testService.addNewPage(dto);
        List<TestBoardListResponseDTO> allList = testService.findAllList();
        model.addAttribute("bList", allList);
        return "redirect:/testSpring/list";
    }

    // 게시글 지우기 기능
    @GetMapping
    public String delete(){

        return "redirect:/testSpring/list";
    }


}
