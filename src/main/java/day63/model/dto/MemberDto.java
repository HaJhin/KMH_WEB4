package day63.model.dto;

import day63.model.entitiy.MemberEntity;
import lombok.*;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class MemberDto {

    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String cdate;
    private String udate;

    // DTO -> entity
    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();
    }

} // class ed
