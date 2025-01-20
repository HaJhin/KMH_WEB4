package day65task.controller;

import day65task.model.dto.OrderDto;
import day65task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/mypage")
    public List<OrderDto> mypage(@RequestParam int mno) {
        return memberService.mypage(mno);
    }

    @PostMapping("/order")
    public boolean order(@RequestBody OrderDto orderDto) {
        return memberService.order(orderDto);
    }

}
