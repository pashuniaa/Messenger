package com.example.Messenger.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    private final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

//    @GetMapping
//    public Optional<Account> findAccountById(@RequestParam Long accountId){
//        return service.findAccountById(accountId);
//    }

    @PostMapping("/account")
    public void addNewUser(@RequestBody Account account){

    }
}
