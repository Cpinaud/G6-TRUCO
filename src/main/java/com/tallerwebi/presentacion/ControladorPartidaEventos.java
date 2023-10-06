package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPartidaEventos {

    private DatosEvento datosEvento;
    private ServicioPartida servicioPartida;
/*
    @Autowired
    public ControladorPartidaEventos(ServicioPartida servicioPartida) {
        this.servicioPartida = servicioPartida;

    }*/

    @RequestMapping(path = "/eventoPartida", method = RequestMethod.GET)
    public ModelAndView eventoPartida(EventoPartida eventoPartida) {
        ModelAndView model = new ModelAndView();

        switch (eventoPartida) {
            case truco:
                model.addObject("evento", "Le canto Truco");
                model.setViewName("partida");
            break;
            case retruco:
                model.addObject("evento", "Le canto Retruco");
                model.setViewName("partida");
            break;
            case vale_cuatro:
                model.addObject("evento", "Le canto Vale Cuatro");
                model.setViewName("partida");
            break;
            case envido:
                model.addObject("evento", "Le canto Envido");
                model.setViewName("partida");
            break;
            case real_envido:
                model.addObject("evento", "Le canto Real Envido");
                model.setViewName("partida");
            break;
            case falta_envido:
                model.addObject("evento", "Le canto Falta Envido");
                model.setViewName("partida");
            break;
        }
        return model;

    }
/*
    @RequestMapping(path = "/eventoJugador", method = RequestMethod.GET)
    public ModelAndView eventoJugador(EventoPartida eventoPartida) {
        ModelAndView model = new ModelAndView();
        */
}

