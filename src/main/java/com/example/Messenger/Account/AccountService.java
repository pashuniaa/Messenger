package com.example.Messenger.Account;

import com.example.Messenger.Websocket.UserHandshakeHandler;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);

    private final AccountRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    public String signUpAccount(Account account){
        boolean userExists = repository.findByEmail(account.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = passwordEncoder.encode(account.getPassword());

        account.setPassword(encodedPassword);

        repository.save(account);

        //TODO send confirmation token

        return "it works";
    }
}
