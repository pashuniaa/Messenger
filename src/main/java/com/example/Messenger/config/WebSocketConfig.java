package com.example.Messenger.config;

import com.example.Messenger.UserHandshakeHandler;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/ws");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/our-websocket")
                .setHandshakeHandler(new UserHandshakeHandler(){
                    public boolean beforeHandshake(
                            ServerHttpRequest request,
                            ServerHttpResponse response,
                            WebSocketHandler wsHandler,
                            Map attributes) throws Exception {

                        if (request instanceof ServletServerHttpRequest) {
                            ServletServerHttpRequest servletRequest
                                    = (ServletServerHttpRequest) request;
                            HttpSession session = servletRequest
                                    .getServletRequest().getSession();
                            attributes.put("sessionId", session.getId());
                        }
                        return true;
                    }
                })
                .withSockJS();
    }
}

/*
* @Override
public void registerStompEndpoints(StompEndpointRegistry registry) {

registry
  .addEndpoint("/greeting")
  .setHandshakeHandler(new DefaultHandshakeHandler() {

      public boolean beforeHandshake(
        ServerHttpRequest request,
        ServerHttpResponse response,
        WebSocketHandler wsHandler,
        Map attributes) throws Exception {

            if (request instanceof ServletServerHttpRequest) {
                ServletServerHttpRequest servletRequest
                 = (ServletServerHttpRequest) request;
                HttpSession session = servletRequest
                  .getServletRequest().getSession();
                attributes.put("sessionId", session.getId());
            }
                return true;
        }}).withSockJS();
    }*/



















