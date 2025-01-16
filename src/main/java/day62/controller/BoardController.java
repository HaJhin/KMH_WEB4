package day62.controller;

import day62.model.entity.BoardEntity;
import day62.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스)을 주입힌다. (싱글톤을 사용하지 않는다.)
// 1. 사용자가 보내는 HTTP(fetch/talend API) 요청은 모두 Controller 에서 찾는다. (HTTP 요청이 오고 응답이 가는 곳)
public class BoardController {
    // 싱글턴 x : 스프링은 자동으로 빈(인스턴스)를 생성하고 관리를 해준다. 개발자가 인스턴스 관리를 위임한다. IOC : 제어의 역전
    @Autowired
    private BoardService boardService;
    // 컨트롤러는 무조건 서비스와 통신한다.
        // 규칙 : 컨트롤러에서 리포지토리/엔티티 객체를 사용하면 안된다.

    // 프레임워크 CRUD 어노테이션
    // @PostMapping @GetMapping @PutMapping @DeleteMapping
    // HTTP 데이터 요청 전송방식 : 1. HTTP Header body @RequestBody vs 2. queryString : @RequestParam

    // C : 게시물 쓰기
    @PostMapping("/signup.do") // http://localhost:8080/signup.do
    public boolean signup(@RequestBody BoardEntity boardEntity) {
        return boardService.signup(boardEntity);
    }

    // R : 게시물 전체 조회
    @GetMapping("/printall.do") // http://localhost:8080/printall.do
    public List<BoardEntity> printAll() {
        return boardService.printAll();
    }

    // R : 게시물 개별 조회
    @GetMapping("/findid.do") // http://localhost:8080/findid.do
    public BoardEntity findId(@RequestParam int bno) {
        BoardEntity entity = boardService.findId(bno);
        return entity;
    }

    // U : 게시물 수정
    @PutMapping("/update.do") // http://localhost:8080/update.do
    public boolean update(@RequestBody BoardEntity boardEntity) {
        return boardService.update(boardEntity);
    }

    // D : 게시물 삭제
    @DeleteMapping("/delete.do") // http://localhost:8080/delete.do
    public boolean delete(@RequestParam int bno) {
        return boardService.delete(bno);
    }

} // class ed
