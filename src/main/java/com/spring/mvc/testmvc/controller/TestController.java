package com.spring.mvc.testmvc.controller;

import com.spring.mvc.testmvc.dto.TestReponseDTO;
import com.spring.mvc.testmvc.entity.TestBoard;
import com.spring.mvc.testmvc.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    private TestReponseDTO dto;



    @GetMapping("/list")
    public String showList(Model model){
        System.out.println("/test/list : get");

        List<TestBoard> all = testService.findAlll();
        System.out.println(all);
        model.addAttribute("cList",all);
        return "chap05/list";
    }
}
