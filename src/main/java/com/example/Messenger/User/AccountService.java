package com.example.Messenger.User;

import com.example.Messenger.UserHandshakeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);
    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

//    public Optional<Account> findAccountById(Long accountId) {
//        return repository.findAccountById(accountId);
//    }

    public void addNewAccount(Account account){
        if(repository.findAccountById(account.getId()) != null){
            LOG.info("Account with ID '{}' already exists", account.getId());
        }
        else{
            repository.save(new Account(account.getId(),
                    "Name",
                    "Surname",
                    "messenger@mail.com",
                    "password123"));
        }
    }


}
