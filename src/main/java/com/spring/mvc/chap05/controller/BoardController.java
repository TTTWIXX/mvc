package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.BoardDetailResponseDTO;
import com.spring.mvc.chap05.dto.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.BoardUpdateRequestDTO;
import com.spring.mvc.chap05.dto.BoardWriteRequestDTO;
import com.spring.mvc.chap05.dto.page.Page;
import com.spring.mvc.chap05.dto.page.PageMaker;
import com.spring.mvc.chap05.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // 목록 조회 요청
    @GetMapping("/list")
    public String list(Model model, Page page) {
        log.info("/board/list : GET");
        log.info("PAGE : {} ", page);
        List<BoardListResponseDTO> responseDTOS
                = boardService.getList(page);
        model.addAttribute("bList", responseDTOS);
        // 페이징 알고리즘 작동
        PageMaker pageMaker = new PageMaker(page, boardService.getCount());
        model.addAttribute("maker", pageMaker);

        return "chap05/list";
    }

    // 글쓰기 화면 조회 요청
    @GetMapping("/write")
    public String write() {
        System.out.println("/board/write : GET");
        return "chap05/write";
    }

    // 글 등록 요청 처리
    @PostMapping("/write")
    public String write(BoardWriteRequestDTO dto) {
        System.out.println("/board/write : POST");
        boardService.register(dto);
        return "redirect:/board/list";
    }

    // 글 삭제 요청 처리
    @GetMapping("/delete")
    public String delete(int bno) {
        System.out.println("/board/delete : GET");
        boardService.delete(bno);
        return "redirect:/board/list";
    }

    // 글 상세 조회 요청
    @GetMapping("/detail")
    public String detail(int bno, Model model) {
        System.out.println("/board/detail : GET");
        model.addAttribute("b", boardService.getDetail(bno));
        return "chap05/detail";
    }

    // 글 수정 화면 요청
    @GetMapping("/update")
    public String update(int bno, Model model) {
        System.out.println("/board/update : GET");
        // 기존에 입력한 정보 보내주기
        model.addAttribute("b", boardService.getDetail(bno));
        return "chap05/update";

    }

    // 수정 정보 처리 요청
    @PostMapping("/showUpdate")
    public String showUpdate(BoardUpdateRequestDTO dto) {
        boardService.update(dto);
        return "redirect:/board/list";
    }


}
