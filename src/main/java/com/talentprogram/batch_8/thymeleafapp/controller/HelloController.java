package com.talentprogram.batch_8.thymeleafapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/sayhello")
    public String helloPage(Model model){
        model.addAttribute("name","Myo Thiha Kyaw");
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("items", List.of("Apple","Banana","Cherry"));
        return "hello";
    }
}
