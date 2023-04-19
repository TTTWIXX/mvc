package com.spring.mvc.test_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pos")
public class PostController {

    @GetMapping("/start")
    public String startPos(){
        System.out.println("시작");
        return "testSpring/posItems";
    }

}
