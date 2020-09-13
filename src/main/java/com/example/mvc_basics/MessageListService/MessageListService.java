package com.example.mvc_basics.MessageListService;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messages;

    public MessageListService() {

    }

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }
}
