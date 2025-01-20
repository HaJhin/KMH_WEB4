package day65task.model.dto;

import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.model.entity.ProductEntity;
import lombok.*;

@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
public class OrderDto {
    private int ono;
    private int ocount;


    // toEntity
    public OrderEntity toEntity() {
        return OrderEntity.builder()
                .ono(this.ono)
                .ocount(this.ocount)
                .build();
    }
}
