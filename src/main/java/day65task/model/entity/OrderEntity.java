package day65task.model.entity;

import day65task.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "porder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono;

    @Column(columnDefinition = "int")
    private int ocount;

    // 단방향 통신
    @ToString.Exclude @ManyToOne // FK
    @JoinColumn(name = "mno") // FK 필드명
    private MemberEntity memberEntity;

    // 단방향 통신
    @ToString.Exclude @ManyToOne // FK
    @JoinColumn(name = "pno") // FK 필드명
    private ProductEntity productEntity;

    // toDto
    public OrderDto toDto() {
        return OrderDto.builder()
                .ono(this.ono)
                .ocount(this.ocount)
                .build();
    }
}
