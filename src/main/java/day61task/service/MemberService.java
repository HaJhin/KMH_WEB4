package day61task.service;

import day61task.model.entity.MemberEntity;
import day61task.model.repository.MemberRepository;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(String id , String pw) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.id = id;
        memberEntity.pw = pw;
        // 2. 생성한 엔티티를 DB에 저장하기
        memberRepository.save(memberEntity);
        return true;
    }

    public List<MemberEntity> findAll() {
        // 1. 현재 엔티티와 매핑된 테이블의 모든 레코드 조회
        List<MemberEntity> list = memberRepository.findAll();
        return null;
    }
}
