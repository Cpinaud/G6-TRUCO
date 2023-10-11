package com.tallerwebi.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyChannelInterception implements ChannelInterceptor {
    Integer cantidadDeJugadores = 0;
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        if (StompCommand.SUBSCRIBE.equals(accessor.getCommand())) {
            cantidadDeJugadores++;

        }else if (StompCommand.UNSUBSCRIBE.equals(accessor.getCommand())) {
            cantidadDeJugadores--;
        }
        return message;
    }

    public Integer getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }
}

