package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Sala;
import com.tallerwebi.dominio.ServicioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

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
            return model;

        }else {
            model.addObject("ninguna_sala", "No hay ninguna sala");
            model.setViewName("salas");
            return model;
        }


    }
    @RequestMapping(path = "/crear_sala", method = RequestMethod.POST)
    public ModelAndView crearsala(){
        return new ModelAndView("redirect:/iniciarPartida");
    }



    //Ver HttpServletRequest request como parametro.
    @RequestMapping(path = "/ingresar_a_sala", method = RequestMethod.POST)
    public ModelAndView IngresaraSala(@ModelAttribute("nombre_sala") String nombre_sala) {
        ModelAndView model = new ModelAndView();

        servicioSala.obtenersala(nombre_sala);
        model.setViewName("redirect:/partida");
        return model;
    }



    //codigo del controlador de iniciar partida
    @GetMapping("/iniciarPartida")
    public ModelAndView mostrarFormulario2() {
        ModelAndView model = new ModelAndView();
        model.setViewName("iniciarPartida");
        return model;

    }

    @PostMapping("/iniciar")
    public ModelAndView creadordesala(@RequestParam("cantidadDejugadores") String cantidadDejugadores, ModelAndView model) {
        int cantidadJugadoresInt = Integer.parseInt(cantidadDejugadores);
        String nombre_sala = StringAleatorio();
        Sala sala = new Sala(nombre_sala,cantidadJugadoresInt,1);
        Boolean salacreada = servicioSala.crearsala(sala);
        if (salacreada) {

            model.addObject("cantidadJugadoresInt", cantidadJugadoresInt);
            model.setViewName("redirect:/partida");
            return model;
        }else {
            model.addObject("error_crear_sala", "Error al crear la sala");
            return model;
        }

    }

    private String StringAleatorio() {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 18) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            return saltStr;

        }
    }



