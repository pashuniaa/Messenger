package com.example.Messenger.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat/{userid1}/{userid2}")
    public ArrayList<Message> getChatMessages(@PathVariable String userid1, @PathVariable String userid2){

        return null;//chatService.getChatMessages(userid1, userid2);
    }
}
