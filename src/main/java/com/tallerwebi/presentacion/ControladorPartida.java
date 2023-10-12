package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPartida {
    private ServicioPartida servicioPartida;

    @Autowired
    public ControladorPartida(ServicioPartida servicioPartida) {
        this.servicioPartida = servicioPartida;
    }

        @GetMapping("/iniciarPartida")
        public String mostrarFormulario() {
            return "iniciarPartida";
        }

    @RequestMapping("/esperarSala")
    public ModelAndView esperarSala(@ModelAttribute("cantidadDejugadores") String cantidadJugadores, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        request.getSession().setAttribute("cantidadDeJugadores", cantidadJugadores);
        model.addObject("cantidadJugadoresInt", cantidadJugadores);

//        int cantidadJugadoresInt = Integer.parseInt(cantidadJugadores);
//        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
//        servicioPartida.crearPartida(usuario, 2);

        model.setViewName("salas");
        return model;
    }
    @RequestMapping("/partida")
    public ModelAndView iniciarPartida( HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String cantidadDeJugadores = (String) request.getSession().getAttribute("cantidadDeJugadores");

        int cantidadJugadoresInt = Integer.parseInt(cantidadDeJugadores);
        servicioPartida.crearPartida(usuario, 2);




            model.addObject("carta1", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(0));
            model.addObject("carta2", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(1));
            model.addObject("carta3", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(2));
            model.addObject("usuario", usuario);
            model.addObject("cantidadJugadoresEnLaPartida", servicioPartida.obtenerCantDeJugadores());


        model.setViewName("partida");
        return model;

    };
//    @RequestMapping("/partida")
//    public ModelAndView tirarCarta(@RequestParam(name="carta")Integer carta, Long usuario){
//        ModelAndView model = new ModelAndView();
//        servicioPartida.jugarCarta(carta, usuario);
//
//        model.setViewName("partida");
//        return model;
//    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MensajeEnviado getMessages(MensajeRecibido mensajeRecibido) throws Exception {

        //servicioPartida.jugarCarta(mensajeRecibido.getIdCarta(), mensajeRecibido.getUsuarioId());

        return new MensajeEnviado(mensajeRecibido.getMessage());
    }



}
