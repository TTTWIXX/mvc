package com.spring.mvc.chap06;

import com.spring.mvc.jdbc.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody
@RestController // 위에 두개 합침
@RequestMapping("/rests")
public class RestApiController {

    @GetMapping("/foods")
    public List<String> hello() {
//        String[] foodList = {"탕수육", "족발", "마라탕"};
        List<String> foodList = List.of("탕수육", "족발", "마라탕");
        // 배열로 보내면 String[] 이나 List 나 ["",""] 형태로 보낸다.
        return foodList;
    }

    @GetMapping("/person-list")
    public ResponseEntity<?> personList() {
        Person p = new Person(1L, "루피", 3);
        Person p2 = new Person(2L, "딸공", 4);
        Person p3 = new Person(3L, "뽀로", 5);
        return ResponseEntity.ok().body(personList());
    }

    @GetMapping("/bmi")
    public ResponseEntity<?> bmi(@RequestParam(required = false) Double cm, @RequestParam(required = false) Double kg) {

        if (cm == null || kg == null) {
            return ResponseEntity.badRequest().body("키랑 몸무게 보내라");
        }
        double bmi=kg / ((cm * 0.01) * (cm * 0.01));

        HttpHeaders headers = new HttpHeaders();
        headers.add("fruits", "melon");
        headers.add("hobby", "soccer");

        return ResponseEntity.ok().headers(headers).body(bmi);
    }



}
