package day63.controller;

import day63.model.dto.MemberDto;
import day63.model.entitiy.MemberEntity;
import day63.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/day63")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto) {
        return memberService.signup(memberDto);
    } // f ed

    @GetMapping("/infolist.do")
    public List<MemberDto> infolist() {
        return memberService.infolist();
    } // f ed


}
