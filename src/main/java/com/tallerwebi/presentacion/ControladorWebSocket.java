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
    public MensajeEnviado getMessages(MensajeRecibido mensajeRecibido, HttpServletRequest request) throws Exception {
        // Aquí puedes procesar el mensaje recibido y decidir si enviarlo a otros usuarios o no.
        // Puedes acceder a mensajeRecibido.getImageUrl() y mensajeRecibido.getUserId().

        Boolean usuariosIguales = false;
        Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");

        if(mensajeRecibido.getUsuarioId() ==  usuarioActual.getId()) usuariosIguales = true;

        // El mensaje no pertenece al usuario actual, envía la URL de la imagen
        return new MensajeEnviado(mensajeRecibido.getMessage(),usuariosIguales);
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


