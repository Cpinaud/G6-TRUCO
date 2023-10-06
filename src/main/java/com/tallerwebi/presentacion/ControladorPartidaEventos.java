package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(path = "/eventoPartida", method = RequestMethod.POST)
    public ModelAndView eventoPartida(@ModelAttribute("evento")String eventoPartida) {
        ModelAndView model = new ModelAndView();

        model.addObject("evento", "Le canto Truco");
        model.setViewName("partida");

        switch (eventoPartida) {
            case "truco":
                model.addObject("evento", "Le canto Truco");
                model.setViewName("partida");
            break;
            case "retruco":
                model.addObject("evento", "Le canto Retruco");
                model.setViewName("partida");
            break;
            case "vale_cuatro":
                model.addObject("evento", "Le canto Vale Cuatro");
                model.setViewName("partida");
            break;
            case "envido":
                model.addObject("evento", "Le canto Envido");
                model.setViewName("partida");
            break;
            case "real_envido":
                model.addObject("evento", "Le canto Real Envido");
                model.setViewName("partida");
            break;
            case "falta_envido":
                model.addObject("evento", "Le canto Falta Envido");
                model.setViewName("partida");
            break;
        }
        return model;

    }

    @RequestMapping(path = "/eventoJugador", method = RequestMethod.POST)
    public ModelAndView eventoJugador(@ModelAttribute("evento")String eventoJugador) {
        ModelAndView model = new ModelAndView();

        model.addObject("evento", "Quiero");
        model.setViewName("partida");


        switch (eventoJugador) {
            case "quiero":
                model.addObject("evento", "Quiero");
                model.setViewName("partida");
                break;
            case "no_quiero":
                model.addObject("evento", "No Quiero");
                model.setViewName("partida");
                break;
            case "al_maso":
                model.addObject("evento", "Me voy al maso");
                model.setViewName("partida");
                break;
            }
            return model;
    }
}