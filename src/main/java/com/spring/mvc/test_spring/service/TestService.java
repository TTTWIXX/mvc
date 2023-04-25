package com.spring.mvc.test_spring.service;

import com.spring.mvc.test_spring.Repository.TestBoardRepository;
import com.spring.mvc.test_spring.dto.TestBoardListResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestService {

    private final TestBoardRepository testRepository;


    public List<TestBoardListResponseDTO> findAllList() {
        return testRepository.findAll().stream()
                .map(d -> new TestBoardListResponseDTO(d))
                .collect(Collectors.toList());
    }
}
