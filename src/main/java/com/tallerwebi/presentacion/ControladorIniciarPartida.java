 package com.tallerwebi.presentacion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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