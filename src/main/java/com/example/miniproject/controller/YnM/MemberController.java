package com.example.miniproject.controller.YnM;

import com.example.miniproject.constant.Quitstatus;
import com.example.miniproject.constant.Role;
import com.example.miniproject.dto.MemberDTO;
import com.example.miniproject.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/YnM/user")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(MemberDTO memberDTO){
        return "YnM/user/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@Valid MemberDTO memberDTO, BindingResult bindingResult) {
        log.info("회원가입 포스트 진입 : " + memberDTO);

        if (bindingResult.hasErrors()) {
            log.info("유효성검사 통과 실패.");
            bindingResult.getAllErrors().forEach(objectError -> log.info(objectError));
            return "YnM/user/signUp";
        }

        try {
            memberDTO.setQuitstatus(Quitstatus.LIVE);
            memberDTO.setRole(Role.USER);
            memberService.register(memberDTO);
        } catch (IllegalStateException e) {
            return "YnM/user/signUp";
        }

        return "redirect:/YnM";
    }

    @GetMapping("/login")
    public String loginGet(){
        log.info("로그인 페이지 입장..");
        return "YnM/user/login";
    }

}
