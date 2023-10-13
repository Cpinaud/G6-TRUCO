package com.tallerwebi.presentacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tallerwebi.dominio.MensajeEnviado;
import com.tallerwebi.dominio.MensajeRecibido;
import com.tallerwebi.dominio.Usuario;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorWebSocket {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MensajeEnviado getMessages(MensajeRecibido mensajeRecibido) throws Exception {

        return new MensajeEnviado(mensajeRecibido.getMessage(), mensajeRecibido.getUsuarioId());
    }
}


