package com.spring.mvc.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hw")
public class LoginController {
    /*
        1번요청: 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form :GET
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-form.jsp
        - html form: 아이디랑 비번을 입력받으세요.

        2번요청: 로그인 검증하기
        - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
        - 요청 URL : /hw/s-login-check : POST
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

     */
    @GetMapping("/s-login-form")
    public String loginStart() {
        System.out.println("로그인 성공");

        return "/chap03/s-form";
    }

    @PostMapping("/s-val")
    public String loginValidate(String id, String pw, Model model) {

        System.out.println("로그인 검증");
        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        String result=null;
        if (id.equals("grape111") && pw.equals("ggg999")) {
           result="로그인 성공";
            model.addAttribute("result",result);
        } else if (id.equals("grape111") && !pw.equals("ggg999")) {
            result="비밀번호가 틀렸습니다.";
            model.addAttribute("result", result);
        } else if (!id.equals("grape111") && pw.equals("ggg999")) {
            result="아이디가 존재하지 않습니다.";
            model.addAttribute("result", result);
        } else{
            result="존재하지 않는 계정입니다.";
            model.addAttribute("result", result);
        }
        System.out.println(model);

        return "/chap03/s-result";
    }
}
