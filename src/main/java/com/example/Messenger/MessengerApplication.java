package com.example.Messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class MessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);

		//SUKURIAM NAUJUS ID
		ArrayList<String> list = new ArrayList<>();
		list.add("21cda434-1b74-4d2e-b876-1e52440fb088");
		list.add("31cda434-1b74-4d2e-b876-1e52440fb088");

	}
}
