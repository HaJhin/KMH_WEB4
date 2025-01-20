package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(columnDefinition = "varchar(30)" , nullable = false)
    private String pname;

    @Column(columnDefinition = "int" , nullable = false)
    private int pprice;

    // 양방향 통신
    @OneToMany(mappedBy = "productEntity" , cascade = CascadeType.ALL)
    @ToString.Exclude @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();

}
