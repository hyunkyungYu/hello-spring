package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 멤버 서비스를 스프링 컨테이너에 있는 멤버서비스에 연결 해줌.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
