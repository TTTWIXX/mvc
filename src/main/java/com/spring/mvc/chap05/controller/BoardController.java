package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.BoardWriteRequestDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    // 목록 조회 요청
    @GetMapping("/list")
    public String showList(Model model){
        System.out.println("/list/board");
        List<Board> boardList = boardService.showAll();
        System.out.println(boardService.showAll());
        model.addAttribute("bList",boardList);
        return "/chap05/list";
    }



    // 글쓰기 화면 조회 요청


    // 글 등록 요청 처리

    // 글 삭제 요청 처리

    // 글 상세 조회 요청


}
