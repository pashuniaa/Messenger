package com.example.Messenger.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ResponseMessage getMessage(final Message message) throws InterruptedException {
        System.out.println("RECEIVED MESSAGE: \n" + message.getMessageContent());
        Thread.sleep(1000);
        return new ResponseMessage(message.getMessageContent());
    }

    // IS SCRIPT FAILO METODAS
    // stompClient.send("/ws/private-message", {}, JSON.stringify({'messageContent': $("#private-message").val()}));
    // NUKREIPIA MUS CIA

    @MessageMapping("/private-message")
    @SendToUser("/topic/private-messages")
    public void getAndSendPrivateMessage(final Message message, final Principal principal) throws InterruptedException {
        System.out.println("RECEIVED MESSAGE: \n" + message.getMessageContent() + " || SENDING TO: " + message.getSendTo());

        Thread.sleep(1000);

        ResponseMessage response = new ResponseMessage(message.getMessageContent());
        messagingTemplate.convertAndSendToUser(message.getSendTo(), "/topic/private-messages", response);
    }
}