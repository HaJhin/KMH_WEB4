package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(30)" , nullable = false , unique = true)
    private String mid;

    @Column(columnDefinition = "varchar(30)" , nullable = false)
    private String mpwd;

    @Column(columnDefinition = "varchar(10)" , nullable = false , unique = true)
    private String mname;

    @Column(columnDefinition = "varchar(13)" , nullable = false , unique = true)
    private String mphone;

    // 양방향 통신

    @OneToMany(mappedBy = "memberEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();
}
