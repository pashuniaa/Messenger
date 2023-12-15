package com.example.Messenger.Websocket;

import com.example.Messenger.chat.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsocketController {

    @Autowired
    private WebSocketService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message){
        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id, @RequestBody final Message message){
        service.notifyUser(id, message.getMessageContent());
    }
}























