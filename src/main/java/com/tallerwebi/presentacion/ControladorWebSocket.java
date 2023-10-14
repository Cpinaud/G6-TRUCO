package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.MensajeEnviado;
import com.tallerwebi.dominio.MensajeRecibido;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Controller
public class ControladorWebSocket {
private final WebSocketRegistroDeUsuarios registroUsuarios;

public ControladorWebSocket(WebSocketRegistroDeUsuarios registroUsuarios){
    this.registroUsuarios = registroUsuarios;
}
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MensajeEnviado getMessages(MensajeRecibido mensajeRecibido,  SimpMessageHeaderAccessor headerAccessor) throws Exception {

//        String sessionId = headerAccessor.getSessionId();
//        Long usuarioId = mensajeRecibido.getUsuarioId();
//
//        // Registra al usuario con su sesión
//        registroUsuarios.registerUser(sessionId, usuarioId);

        //retorna el mensaje con el ID del usuario
        return new MensajeEnviado(mensajeRecibido.getMessage(), mensajeRecibido.getUsuarioId());
    }

    @MessageExceptionHandler
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        String sessionId = event.getSessionId();

        // Elimina al usuario cuando se desconecta
        Long usuarioId = registroUsuarios.getUserBySessionId(sessionId);
        if (usuarioId != null) {
            registroUsuarios.removeUser(sessionId);
        }
    }
}


