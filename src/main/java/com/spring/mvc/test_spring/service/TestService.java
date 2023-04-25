package com.spring.mvc.test_spring.service;

import com.spring.mvc.test_spring.Entity.TestBoard;
import com.spring.mvc.test_spring.Repository.TestBoardRepository;
import com.spring.mvc.test_spring.dto.TestBoardListResponseDTO;
import com.spring.mvc.test_spring.dto.TestRequestDTO;
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


    public boolean addNewPage(TestRequestDTO dto){

       return testRepository.save(new TestBoard(dto));
    }


}
