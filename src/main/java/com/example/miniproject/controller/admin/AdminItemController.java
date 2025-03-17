package com.example.miniproject.controller.admin;

import com.example.miniproject.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin/item")
@RequiredArgsConstructor
public class AdminItemController {
    private final ItemService itemService;

    @GetMapping("/create")
    public String get() {
        return "admin/itemlist";
    }
}
