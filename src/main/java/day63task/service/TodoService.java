package day63task.service;

import day63.model.dto.MemberDto;
import day63.model.entitiy.MemberEntity;
import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public boolean sign(TodoDto todoDto) {
        TodoEntity todoEntity = todoDto.toEntity(); // DTO자료를 Entity로 전환
        TodoEntity saveEntity = todoRepository.save(todoEntity); // 엔티티를 저장하고 저장 결과를 객체로 보관
        if (saveEntity.getTno() > 0) {return true;} else {return false;}
    } // f ed

    public List<TodoDto> list() {
        List<TodoDto> list = new ArrayList<>();
        List<TodoEntity> todoEntitys = todoRepository.findAll();
        for (int i = 0; i < todoEntitys.size(); i++) {
            TodoEntity todoEntity = todoEntitys.get(i);
            TodoDto todoDto = todoEntity.toDto();
            list.add(todoDto);
        } // for ed
        return list;
    } // f ed

    @Transactional
    public boolean update(int tno) {
        TodoEntity todoEntity = todoRepository.findById(tno).get();
        todoEntity.setTstatus(!todoEntity.isTstatus());
        return true;
    } // f ed

    public boolean delete(int tno) {
        todoRepository.deleteById(tno);
        return true;
    } // f ed

} // service ed
