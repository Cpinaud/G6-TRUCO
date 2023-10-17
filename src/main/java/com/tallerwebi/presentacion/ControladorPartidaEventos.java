package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.hibernate.sql.InFragment.NULL;

@Controller
public class ControladorPartidaEventos {

    private DatosEvento datosEvento;
    private ServicioPartida servicioPartida;
    /*
        @Autowired
        public ControladorPartidaEventos(ServicioPartida servicioPartida) {
            this.servicioPartida = servicioPartida;

        }*/
    @RequestMapping(path = "/truco", method = RequestMethod.POST)
    public ModelAndView eventotruco() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("truco",2);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Truco");
        model.setViewName("partida");
        return model;
    }
    @RequestMapping(path = "/retruco", method = RequestMethod.POST)
    public ModelAndView eventoretruco() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("retruco",3);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Retruco");
        model.setViewName("partida");
        return model;
    }

    @RequestMapping(path = "/vale_cuatro", method = RequestMethod.POST)
    public ModelAndView eventovale_cuatro() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("vale_cuatro",4);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Vale Cuatro");
        model.setViewName("partida");
        return model;
    }

    @RequestMapping(path = "/envido", method = RequestMethod.POST)
    public ModelAndView eventoenvido() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("envido",2);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Envido");
        model.setViewName("partida");
        return model;
    }

    @RequestMapping(path = "/real_envido", method = RequestMethod.POST)
    public ModelAndView eventoreal_envido() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("real_envido",3);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Real Envido");
        model.setViewName("partida");
        return model;
    }


    //como obtener la cantidad de puntos faltantes para ganar para calcular el valor.
    @RequestMapping(path = "/falta_envido", method = RequestMethod.POST)
    public ModelAndView eventofalta_envido() {
        ModelAndView model = new ModelAndView();
        EventoPartida eventoPartida = new EventoPartida("falta_envido",10);
        datosEvento = new DatosEvento(eventoPartida);
        model.addObject("evento", "Le canto Falta Envido");
        model.setViewName("partida");
        return model;
    }

    @RequestMapping(path = "/quiero", method = RequestMethod.POST)
    public ModelAndView eventoquiero() {
        ModelAndView model = new ModelAndView();
        model.addObject("evento", "Quiero");
        model.setViewName("partida");
        return model;
    }
    @RequestMapping(path = "/no_quiero", method = RequestMethod.POST)
    public ModelAndView eventono_quiero() {
        ModelAndView model = new ModelAndView();
        model.addObject("evento", "No Quiero");
        model.setViewName("partida");
        return model;
    }
    @RequestMapping(path = "/al_maso", method = RequestMethod.POST)
    public ModelAndView eventoal_maso() {
        ModelAndView model = new ModelAndView();
        model.addObject("evento", "Me voy al maso");
        model.setViewName("partida");
        return model;
    }
    /*
        En caso de volver a intertar el eventoPartida, hay que cambiar en el html de partida
        todos los actions de los eventos, ej: de truco a falta envido por eventoPartida y de
        quiero a al maso por eventoJugador.


    @RequestMapping(path = "/eventoPartida", method = RequestMethod.POST)
    public ModelAndView eventoPartida(@ModelAttribute("evento")EventoPartida evento) {
        ModelAndView model = new ModelAndView();


            model.addObject("evento", evento.getevento());
            model.setViewName("partida");

        switch (evento.getevento()) {
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

     */
}