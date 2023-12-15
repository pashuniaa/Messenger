package com.example.Messenger.Account;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {

    private final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final AccountService service;

    @PostMapping("/account")
    public void addNewUser(@RequestBody Account account){

    }
}
