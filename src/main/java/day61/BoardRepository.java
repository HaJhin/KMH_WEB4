package day61;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // SPRING MVC 패턴에서 Repository 담당 역할
public interface BoardRepository
        extends JpaRepository<BoardEntity , Integer> {

}
