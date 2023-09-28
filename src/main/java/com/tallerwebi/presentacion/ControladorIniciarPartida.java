package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.dominio.excepcion.UsuarioExistente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
public class ControladorIniciarPartida {


    @GetMapping("/iniciarPartida")
    public String mostrarFormulario() {
        return "iniciarPartida";
    }

    @PostMapping("/iniciar")
    public String mostrarTexto(@RequestParam("cantidadDejugadores") String cantidadDejugadores, Model model) {
        int cantidadJugadoresInt = Integer.parseInt(cantidadDejugadores);
        model.addAttribute("cantidadJugadoresInt", cantidadJugadoresInt);
        return "partida";
    }


}