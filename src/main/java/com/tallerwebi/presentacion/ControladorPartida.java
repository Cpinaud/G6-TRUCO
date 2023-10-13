package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
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


    @RequestMapping("/partida")
    public ModelAndView iniciarPartida( HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        servicioPartida.crearPartida(usuario, 1);

        model.addObject("carta1", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(0));
        model.addObject("carta2", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(1));
        model.addObject("carta3", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(2));
        model.addObject("usuario", usuario);

        model.setViewName("partida");
        return model;
    }
    @RequestMapping(value = "/partida", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Jugada manejarJugada(@RequestBody DatosJugada jugada) {
        servicioPartida.jugarCarta(jugada.getJugador(), jugada.getCarta());
        return servicioPartida.obtenerUltimaJugada();
    }




}
