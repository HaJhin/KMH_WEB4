package day61task.controller;

import day61task.model.entity.MemberEntity;
import day61task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈(객체)를 가져온다.
    private MemberService memberService;

    @PostMapping("/signup")
    public boolean signup(@RequestParam String id , @RequestParam String pw) {
        boolean result = memberService.signup(id,pw);
        return result;
    }

    @GetMapping("/findall")
    public List<MemberEntity> findAll() {
        List<MemberEntity> result = memberService.findAll();
        return result;
    }


}
