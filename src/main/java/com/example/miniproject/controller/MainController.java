package com.example.miniproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")
    public String main(){
        return "ynm/main";
    }

    @GetMapping("/ynm")
    public String main2(){
        return "ynm/main";
    }

    @GetMapping("/ynm/main")
    public String main3(){
        return "ynm/main";
    }

    @GetMapping("/양말")
    public String main4(){
        return "ynm/main";
    }

    @GetMapping("/양앤말")
    public String main5(){
        return "ynm/main";
    }
}
