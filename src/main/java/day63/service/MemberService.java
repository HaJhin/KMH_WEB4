package day63.service;

import day63.model.dto.MemberDto;
import day63.model.entitiy.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto) {
        // 1. 저장할 DTO를 entity로 변환
        MemberEntity memberEntity = memberDto.toEntity();
        // 2. 변환된 entity를 save한다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);
        // 3. save한 결과를 entity로 반환받는다.
        // 4. 회원번호를 확인해서 엔티티가 잘 생성되었는지 확인
        if(saveEntity.getMno() > 0) { return true; } else { return false; }
    } // f ed

    public List<MemberDto> infolist() {
        // 모든 엔티티 조회
        List<MemberEntity> memberEntities = memberRepository.findAll();
        // 모든 엔티티 DTO 전환
        List<MemberDto> list = new ArrayList<>(); // DTO들을 저장할 리스트 선언
        for (int i = 0; i < memberEntities.size(); i++) {
            MemberEntity memberEntity = memberEntities.get(i); // entity 리스트 안의 i번째 인덱스 반환
            list.add(memberEntity.toDto()); // i번째 인덱스를 DTO 전환 후 DTO 리스트 안에 저장
        }
        return list; // DTO 리스트 반환
    }
}
