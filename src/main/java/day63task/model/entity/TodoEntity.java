package day63task.model.entity;

import day63task.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todolist")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class TodoEntity extends TodoBaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno;

    @Column(columnDefinition = "varchar(100)" , nullable = false)
    private String tcontent;

    @Column(columnDefinition = "boolean")
    private boolean tstatus;

    public TodoDto toDto() {
        return TodoDto.builder()
                .tno(this.tno)
                .tcontent(this.tcontent)
                .tstatus(this.tstatus)
                .build();
    }
}
