package com.example.Messenger;

import com.example.Messenger.chat.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyFrontend(final String message){
        ResponseMessage response=new ResponseMessage(message);
        messagingTemplate.convertAndSend("/topic/message", response);
    }

    // CIA MES GAUNAME ID IR MESSAGE KAD SIUSTI ADRESATUI I FRONTENDA
    public void notifyUser(final String id, final String message){
        ResponseMessage response=new ResponseMessage(message);
        messagingTemplate.convertAndSendToUser(id, "/topic/private-messages", response);
    }
}



























