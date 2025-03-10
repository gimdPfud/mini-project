package com.example.miniproject.controller.YnM;

import com.example.miniproject.dto.MemberDTO;
import com.example.miniproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/ynm")
public class MypageRestController {
    private final MemberService memberService;

    @PostMapping("/myPage/user")
    public ResponseEntity updateGet(MemberDTO memberDTO){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
