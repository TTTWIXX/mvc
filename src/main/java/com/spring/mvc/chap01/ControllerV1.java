package com.spring.mvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

// 어떤 요청들을 처리할지 공통 URL을 설계
@RequestMapping("/spring/*")

// 이 클래스의 객체를 스프링이 관리하도록 빈을 등록
@Controller // @Component 와 같은 개념
public class ControllerV1 {


    // 세부요청들은 메서드를 통해 처리
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("\n=====헬로 요청이 들어옴!=====\n");
        // 어떤 JSP를 열어줄지 경로를 적는다.
        return "hello";

    }


    @RequestMapping("/food")
    public String foods() {
        System.out.println("food보여줌");

        return "chap01/food";
    }

    // 음식 선택 요청 처리
    @PostMapping(value = "/food-select")
    public String foodSelect(
            String foodName,
            String category
    ) {
        System.out.println("foodName = " + foodName);
        System.out.println("category = " + category);
        return "hello";
    }


    //==================요청 파라미터 읽기(Query String parameter)==============//
    // ==1. httpServletRequest 사용하기
    // ==> ex) /spring/person?name=kim&age=30
    @RequestMapping("/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";

    }


    // ==2. @RequestParam 사용하기
    // ==> ex) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/major")
    public String major(
            String stu, // url과 Param 이름이 같으면 annotation 생략
            @RequestParam("major") String mj, //major변수가 겹쳐서 다른 변수명을 쓰고싶을때
            // url의 major값을 받아 mj변수로 생성
            @RequestParam(defaultValue = "1") int grade //값을 전달하지 않으면 defaultValue값 가잠
    ) {
        String major = "전공전공";
        System.out.println("stu = " + stu);
        System.out.println("major = " + mj);
        System.out.println("grade = " + grade);

        return "";
    }



    // == 3. 커맨드 객체 이용하기
    // == 쿼리 스트링의 양이 너무 많을 경우 또는 연관성이 있을 경우
    // ==> ex) /spring/order?oNum=20230419007-P&goods=구두&amount=3&price=500000...
    @RequestMapping("/order")
    public String order(OrderRequestDTO dto) {
        System.out.println("dto = " + dto);

        return "";

    }

    // == 4. URL에 경로로 붙어있는 데이터 읽기
    // ==> /spring/member/hong/107
    //      hong 이라는 유저의 107번 게시글을 읽고싶음
    @RequestMapping("/member/{userName}/{bNo}")

    public String member(
            @PathVariable String userName,
            @PathVariable long bNo
    ) {
        System.out.println("userName = " + userName);
        System.out.println("bNo = " + bNo);
        return "";
    }


}
