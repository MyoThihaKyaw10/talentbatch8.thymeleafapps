package com.talentprogram.batch_8.thymeleafapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/sayhello")
    public String helloPage(Model model){
        String name = "Myo Thiha Kyaw";
        LocalDate today = LocalDate.now();

        int hour = java.time.LocalTime.now().getHour();
        String greeting;
        if(hour < 12){
            greeting = "Good morning";
        }
        else if (hour < 18) {
            greeting = "Good afternoon";
        }
        else {
            greeting = "Good evening";
        }

        model.addAttribute("greeting",greeting);
        model.addAttribute("name",name);
        model.addAttribute("date",today);
        model.addAttribute("items", List.of("Apple","Banana","Cherry"));
        return "hello";
    }

    @GetMapping("/tasks")
    public String tasksPage(Model model) {
        List<Map<String, String>> tasks = List.of(
                Map.of("id", "1", "title", "Drink water", "status", "Completed"),
                Map.of("id", "2", "title", "Do Homework", "status", "In Progress"),
                Map.of("id", "3", "title", "Sleep", "status", "Pending")
        );
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

}
