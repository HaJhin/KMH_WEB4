package day63task.controller;

import day63.model.dto.MemberDto;
import day63task.model.dto.TodoDto;
import day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/sign.do")
    public boolean sign(@RequestBody TodoDto todoDto) {
        return todoService.sign(todoDto);
    } // f ed

    @GetMapping("/list.do")
    public List<TodoDto> list() {
        return todoService.list();
    } // f ed

    @PutMapping("/update.do")
    private boolean update(@RequestParam int tno) {
        return todoService.update(tno);
    } // f ed

    @DeleteMapping("/delete.do")
    private boolean delete(@RequestParam int tno) {
        return todoService.delete(tno);
    } // f ed
}
