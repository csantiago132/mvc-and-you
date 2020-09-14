package com.example.mvc_basics.controller;

import com.example.mvc_basics.MessageForm;
import com.example.mvc_basics.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    private MessageService messageListService;

    public HomeController(MessageService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings" , messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
}
