package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Partida;
import com.tallerwebi.dominio.ServicioPartida;
import com.tallerwebi.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.setViewName("salas");
        return model;
    }
    @RequestMapping("/partida")
    public ModelAndView iniciarPartida( HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String cantidadDeJugadores = (String) request.getSession().getAttribute("cantidadDeJugadores");
        int cantidadJugadoresInt = Integer.parseInt(cantidadDeJugadores);

//        int cantidadJugadoresInt = Integer.parseInt(cantidadDejugadores);
        //int cantidadJugadoresInt = 1;

        servicioPartida.crearPartida(usuario, cantidadJugadoresInt);

        if (servicioPartida.obtenerCantDeJugadores() == cantidadJugadoresInt){

            model.addObject("carta1", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(0));
            model.addObject("carta2", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(1));
            model.addObject("carta3", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(2));
            model.addObject("usuario", usuario);
            model.addObject("cantidadJugadoresEnLaPartida", servicioPartida.obtenerCantDeJugadores());
        }

        model.setViewName("partida");
        return model;

    };

//    @PostMapping("/iniciar")
//    public String mostrarTexto(@RequestParam("cantidadDejugadores") String cantidadDejugadores) {
//        ModelAndView model = new ModelAndView();
//        int cantidadJugadoresInt = Integer.parseInt(cantidadDejugadores);
//        model.addObject("cantidadJugadoresInt", cantidadJugadoresInt);
//        return "partida";
//    }



}
