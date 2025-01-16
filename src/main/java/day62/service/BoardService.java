package day62.service;

import day62.model.entity.BoardEntity;
import day62.model.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
// 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스)을 주입힌다. (싱글톤을 사용하지 않는다.)
// 1. Spring mvc 패턴에서 추가된/레이어 구역으로 자바의 비지니스 로직 담당
public class BoardService {
    // 비지니스 로직 : 기능의 실질적인 코드
        // 예) 회원가입 : 타입 변환,유효성 검사,자료 가공 (X) 저장에 필요한 코드 SAVE,INSERT (O)
    @Autowired
    private BoardRepository boardRepository;
    // 서비스는 무조건 리포지토리를 이용하여 엔티티를 조작하고 요청과 응답을 받는다.
        // 규칙 : 서비스에서 컨트롤러 객체를 사용하면 안된다.

    // C : 게시물 쓰기
    // http://localhost:8080/signup.do
    public boolean signup(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
            // insert SQl 문을 작성하지 않아도 된다. 자동으로 쿼리가 생성되기 때문에!
        return true;
    } // f ed

    // R : 게시물 전체 조회
    // http://localhost:8080/printall.do
    public List<BoardEntity> printAll() {
    List<BoardEntity> list = boardRepository.findAll();
    return list;
    }

    // R : 게시물 개별 조회
    // http://localhost:8080/findid.do
    public BoardEntity findId(int bno) {
        BoardEntity boardEntity = boardRepository.findById(bno).get();
        return boardEntity;
    }

    // U : 게시물 수정
    // http://localhost:8080/update.do
    @Transactional
    public boolean update(BoardEntity boardEntity) {
        // 1. 수정할 게시물 번호를 이용하여 수정할 엔티티를 찾는다.
        BoardEntity updateEntity = boardRepository.findById(boardEntity.getBno()).get();
        // 2. 수정할 엔티티의 값을 setter 를 이용하여 수정한다.
        updateEntity.setBtitle(boardEntity.getBtitle());
        updateEntity.setBcontent(boardEntity.getBcontent());
            // (영속성) - 엔티티/인스턴스를 수정하면 자동으로 DB도 같이 수정한다.
        return true;
    }

    // D : 게시물 삭제
    // http://localhost:8080/delete.do
    public boolean delete(int bno) {
        // delete SQl문을 작성하지 않고 자동으로 쿼리가 실행된다.
        boardRepository.deleteById(bno);
        return true;
    }
} // class ed
