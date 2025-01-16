package day63.model.entitiy;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberEntity extends BaseTime {

    // === 테이블 필드 속성 설계 === //

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(30)" , nullable = false , unique = true)
    private String mid;

    @Column(columnDefinition = "varchar(20)" , nullable = false)
    private String mpwd;

    @Column(columnDefinition = "varchar(10)" , nullable = false)
    private String mname;

    @Column(columnDefinition = "varchar(13)" , nullable = false , unique = true)
    private String mphone;

    // entity -> DTO // 롬복에서 제공하지 않는 메서드
    public MemberDto toDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();
    } // f ed

} // class ed
