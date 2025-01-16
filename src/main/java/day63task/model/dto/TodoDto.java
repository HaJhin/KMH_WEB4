package day63task.model.dto;

import day63task.model.entity.TodoEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class TodoDto {

    private int tno;
    private String tcontent;
    private boolean tstatus;

    public TodoEntity toEntity() {
        return TodoEntity.builder()
                .tno(this.tno)
                .tcontent(this.tcontent)
                .tstatus(this.tstatus)
                .build();
    }
}
