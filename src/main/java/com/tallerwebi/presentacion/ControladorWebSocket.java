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
    public MensajeEnviado getMessages(MensajeRecibido mensajeRecibido,HttpServletRequest request) throws Exception {
        // Aquí puedes acceder a mensajeRecibido.getImageUrl() y mensajeRecibido.getUserId()
        Long IdUsuarioRecivido = Long.valueOf(mensajeRecibido.getUsuarioId());
        // Verifica si el mensaje debe ser enviado al cliente actual
        if (IdUsuarioRecivido == obtenerIdUsuarioActual(request).getId()) {
            // El mensaje pertenece al usuario actual, puedes decidir no enviarlo
            return null;
        }

        // El mensaje no pertenece al usuario actual, envía la URL de la imagen
        return new MensajeEnviado(mensajeRecibido.getMessage());
    }

    private Usuario obtenerIdUsuarioActual(HttpServletRequest request) {
        return (Usuario) request.getSession().getAttribute("usuario");
    }


//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public String getMessages(MensajeRecibido mensajeRecibido) throws Exception {
//
//        MensajeEnviado mensajeEnviado = new MensajeEnviado(mensajeRecibido.getMessage());
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(mensajeEnviado);
//
//
//        return json;
//    }
}


