package com.example.mvc_basics.service;


import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    public MessageService() {

    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService Bean");
        this.chatMessages = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUppercase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowercase());
            default:
                newMessage.setMessage(chatForm.getMessageText());
                break;
        }
        this.chatMessages.add(newMessage);
    }

    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }
    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }
}
