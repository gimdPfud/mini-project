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
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/ynm/user")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(MemberDTO memberDTO){
        return "ynm/user/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@Valid MemberDTO memberDTO, BindingResult bindingResult) {
        log.info("회원가입 포스트 진입 : " + memberDTO);

        if (bindingResult.hasErrors()) {
            log.info("유효성검사 통과 실패.");
            bindingResult.getAllErrors().forEach(objectError -> log.info(objectError));
            return "ynm/user/signUp";
        }

        try {
            memberDTO.setQuitstatus(Quitstatus.LIVE);
            memberDTO.setRole(Role.USER);
            memberService.register(memberDTO);
        } catch (IllegalStateException e) {
            return "ynm/user/signUp";
        }

        return "redirect:/ynm";
    }

    @GetMapping("/login")
    public String loginGet(){
        log.info("로그인 페이지 입장..");
        return "ynm/user/login";
    }

    @PostMapping("/edit/{bno}")
    public String updateGet(@PathVariable Long bno ){
        /*마이페이지에서 rest방식으로 받아서 처리..*/
        return "ynm/user/myPage";
    }
}
