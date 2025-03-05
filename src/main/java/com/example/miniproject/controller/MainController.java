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
        return "YnM/main";
    }

    @GetMapping("/YnM")
    public String main2(){
        return "YnM/main";
    }

    @GetMapping("/YnM/main")
    public String main3(){
        return "YnM/main";
    }
}
