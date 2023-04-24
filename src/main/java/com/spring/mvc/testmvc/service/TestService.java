package com.spring.mvc.testmvc.service;

import com.spring.mvc.testmvc.dto.TestReponseDTO;
import com.spring.mvc.testmvc.entity.TestBoard;
import com.spring.mvc.testmvc.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private TestBoard board;

    public List<TestReponseDTO> findAlll() {

        return testRepository.findAlll().

    }
}
