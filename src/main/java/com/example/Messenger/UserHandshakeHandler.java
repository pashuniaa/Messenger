package com.example.Messenger;

import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

public class UserHandshakeHandler extends DefaultHandshakeHandler {

    private final Logger LOG = LoggerFactory.getLogger(UserHandshakeHandler.class);


    //Useris atidaro nauja connectiona, sauna sitas metodas, kuris galetu iskart kviesti UserController klases
    //metoda AddNewUser, pries tai patikrinant ar toks jau egzistuoja

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String randomId = UUID.randomUUID().toString();
        //String randomId = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));

        LOG.info("Account with ID '{}' opened the page", randomId);

        return new UserPrincipal(randomId);
    }
}




















