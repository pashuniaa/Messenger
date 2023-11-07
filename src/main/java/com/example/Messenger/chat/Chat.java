package com.example.Messenger.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Chat {

    private Long id;
    private String sentFrom;
    private String sentTo;
    //private ArrayList<Message> messages= new ArrayList<>();

    //reikia sukurti chat controlleri, kur butu get mapping, kuris mums grazintu visa arraylista su musu pokalbiais
    //tada frontendas chronologiskai pagal timestamp ir siuntejo id skirstys kaip delioti chat debeselius
}
