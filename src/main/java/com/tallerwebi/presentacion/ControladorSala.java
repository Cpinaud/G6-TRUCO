package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Sala;
import com.tallerwebi.dominio.ServicioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorSala {
    private ServicioSala servicioSala;
    @Autowired
    public ControladorSala(ServicioSala servicioSala) {
        this.servicioSala = servicioSala;

    }
    @RequestMapping(path = "/salas", method = RequestMethod.GET)
    public ModelAndView irASalas() {
        ModelAndView model = new ModelAndView();
        if (!servicioSala.obtenerlistadeSalas().isEmpty()){
            model.addObject("ListadeSalas",servicioSala.obtenerlistadeSalas());
            return new ModelAndView("salas");

        }else {
            model.addObject("ninguna_sala", "No hay ninguna sala");
            return new ModelAndView("salas");
        }


    }
    @RequestMapping(path = "/crear_sala", method = RequestMethod.POST)
    public ModelAndView crearsala(){
        return new ModelAndView("redirect:/partida");
    }


    @RequestMapping(path = "/ingresar_a_sala", method = RequestMethod.POST)
    public ModelAndView IngresaraSala(@ModelAttribute("id_sala") Long id_sala, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        servicioSala.obtenersala(id_sala);
        model.setViewName("redirect:/iniciarPartida");
        return model;
    }



    //codigo del controlador de iniciar partida
    @GetMapping("/iniciarPartida")
    public String mostrarFormulario() {
        return "iniciarPartida";
    }

    @PostMapping("/iniciar")
    public ModelAndView mostrarTexto(@RequestParam("cantidadDejugadores") String cantidadDejugadores, ModelAndView model) {
        int cantidadJugadoresInt = Integer.parseInt(cantidadDejugadores);
        if (servicioSala.crearsala(new Sala(cantidadJugadoresInt,1))) {

            model.addObject("cantidadJugadoresInt", cantidadJugadoresInt);
            model.setViewName("redirect:/partida");
            return model;
        }else {
            model.addObject("error_crear_sala", "Error al crear la sala");
            return model;
        }

    }



}
