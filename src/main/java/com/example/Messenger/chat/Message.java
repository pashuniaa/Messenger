package com.example.Messenger.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String messageContent;
    private String sendTo;
    private String sendFrom;
}