package com.spring.mvc.etc;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    @Test
    void tttt() {
        Employee build = Employee.builder().position("대리").empName("홍길동").build();
        System.out.println(build);


        Actor actor = Actor.builder().hasPhone(false).actorAge(40).build();

    }

}