package com.spring.mvc.chap04.controller;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


/*
     # 요청 URL
    1. 학생 성적정보 등록화면을 보여주고 성적정보 목록조회 처리
    - /score/list : GET

    2. 성적 정보 등록 처리 요청
    - /score/register : POST

    3. 성적정보 삭제 요청
    - /score/remove : POST

    4. 성적정보 상제 조회 요청
    - /score/detail : GET

 */

@RequestMapping("/score")
@Controller
//@AllArgsConstructor : 모든 필드를 초기화 하는 생성자
@RequiredArgsConstructor // : final 필드만 초기화하는 생성자
public class ScoreController {
    // 저장소에 의존해야 데이터를 받아서 클라이언트에게 응답할 수 있음
    private final ScoreRepository repository;

//    @Autowired
//    // 자동 Autowired 조건
//    // 만약 클래스의 생성자가 단 1개라면
//    // 자동으로 @Autowired 를 써준다.
//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }

    // 1. 성적등록화면 띄우기 + 정보목록조회
    @GetMapping("/list")
    public String list(Model model, String sort) {
        System.out.println("/score/list : GET!");
        List<Score> scoreList = repository.findAll();
        model.addAttribute("sList", scoreList);
        return "chap04/score-list";
    }

    // 2. 성적 정보 등록 처리 요청
    @PostMapping("/register")
    public String register(ScoreRequestDTO dto) {
        //  ^ 이것 때문에 ScoreRequestDTO 에 기본생성자 필요
        // 입력데이터(쿼리스트링) 읽기
        System.out.println("/score/register: POST! - " + dto);

        //ScoreDTO 를 ScoreEntity 로 변환 (repository.save()에서 ScoreEntity 타입을 원하기 때문)
        Score score = new Score(dto);

        // save 명령
        repository.save(score); // 객체지향적으로 Controller 가 하는것이 아니라 Score 에서 변환해준다.

        /*
            등록요청에서 JSP 뷰 포워딩을 하면
            갱신된 목록을 다시한번 저장소에서 불러와
            모델에 담는 추가적인 코드가 필요하지만

            리다이렉트를 통해서 위에서 만든 /score/list : GET
            을 자동으로 다시 보낼 수 있다면 번거로운 코드가
            줄어들 수 있겠다.
         */

        return "redirect:/score/list";
    }

    // 3. 성적 정보 삭제
    @GetMapping("/remove")
    public String remove(int stuNum) {
        System.out.println("/score/remove: GET!");
        repository.deleteByStuNum(stuNum);


        return "redirect:/score/list";
    }

    // 4. 성적정보 상제 조회 요청
    @GetMapping("/showDetail")
    public String showDetail(int stuNum, Model model) {
        List<Score> scoreList = repository.findAll();
        Score scoreFilter = scoreList.stream().filter(d -> d.getStuNum() == stuNum).collect(Collectors.toList()).get(0);
        ScoreRequestDTO scoreDTO=new ScoreRequestDTO(scoreFilter.getName(),scoreFilter.getKor(),scoreFilter.getEng(),scoreFilter.getMath());
        Score score=new Score(scoreDTO);
        System.out.println(score);
        score.setStuNum(stuNum);
        model.addAttribute("score",score);
        return "chap04/score-detail";
    }


    @GetMapping("/sortName")
    public String sortByName(Model model) {
        ScoreRepositoryImpl srp = new ScoreRepositoryImpl();
        List<Score> scoreList = srp.sortByName();
//        System.out.println(scoreList);
        model.addAttribute("sList", scoreList);
        return "chap04/score-list";
    }

    @GetMapping("/updateShow")
    public String updateShow(Score s,Model model) {
        System.out.println(s);

        Score

        model.addAttribute("s",score);
        return "chap04/score-updateShow";
    }
    @GetMapping("/modify")
    public String updateScore(Score score,Model model){
        System.out.println("들어왔니?");
        System.out.println(score);
        List<Score> scoreList = repository.findAll();
        Score scoreChange = scoreList.stream().filter(d -> d.getStuNum() == score.getStuNum()).collect(Collectors.toList()).get(0);
        scoreList.remove(scoreChange);
        Score scoreAfter=new Score(new ScoreRequestDTO(scoreChange.getName(),scoreChange.getKor(),scoreChange.getEng(),scoreChange.getMath()));
        scoreList.add(scoreAfter);
        model.addAttribute("score",scoreAfter);
        return "chap04/score-updateShow";
    }





}
