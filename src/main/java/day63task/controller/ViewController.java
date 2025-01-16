package day63task.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String index() {
        return "/day63task/day63task.html";
    }
}
