package day62.model.repository;


import day61task.model.entity.MemberEntity;
import day62.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스)을 주입힌다. (싱글톤을 사용하지 않는다.)
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
