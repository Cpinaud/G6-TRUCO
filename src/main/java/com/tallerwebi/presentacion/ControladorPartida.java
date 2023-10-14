package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller

public class ControladorPartida {
    private ServicioPartida servicioPartida;
    private final WebSocketRegistroDeUsuarios registroUsuarios;

    @Autowired
    public ControladorPartida(ServicioPartida servicioPartida, WebSocketRegistroDeUsuarios registroUsuarios) {
        this.registroUsuarios = registroUsuarios;
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

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        // Registra al usuario con su sesión
        registroUsuarios.registerUser(usuario.getUsername(), usuario.getId());

        model.setViewName("salas");
        return model;
    }


    @RequestMapping("/partida")
    public ModelAndView iniciarPartida( HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        ArrayList<Long> usuariosConectados = new ArrayList<>(registroUsuarios.obtenerUsuariosConectados().values());

        if (registroUsuarios.obtenerCantidadDeUsuarios() == 2){
            servicioPartida.crearPartida(usuariosConectados);

            model.addObject("carta1", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(0));
            model.addObject("carta2", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(1));
            model.addObject("carta3", servicioPartida.obtenerManoDelJugador(usuario.getId()).get(2));
            model.addObject("usuarioJava", usuario);

            model.setViewName("partida");
            return model;
        }
        

        return model;
    }
    @RequestMapping(value = "/partida", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public Jugada manejarJugada(@RequestBody DatosJugada jugada) {
        servicioPartida.jugarCarta(jugada.getJugador(), jugada.getCarta());


        return servicioPartida.obtenerUltimaJugada();
    }




}
