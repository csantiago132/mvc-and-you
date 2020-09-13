package com.example.mvc_basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("greetings", new String[]{"hi", "hello", "good-bye"});
        return "home";
    }

}
