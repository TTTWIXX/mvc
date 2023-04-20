package com.spring.mvc.test_spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pos")
public class PostController {

    @GetMapping("/start")
    public String startPos() {
        System.out.println("시작");
        return "testSpring/posItems";
    }

    @PostMapping("/check")
    public String checkAge(posDTO pos) {

        return "testSpring/showRules";
    }

}
