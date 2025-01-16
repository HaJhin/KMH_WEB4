package day63.model.entitiy;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 슈퍼 클래스 목적으로 사용될 클래스 (자체적인 매핑 X)
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    private LocalDateTime cdate; // 엔티티의 생성날짜/시간

    @LastModifiedDate
    private LocalDateTime udate; // 엔티티의 수정날짜/시간


}
