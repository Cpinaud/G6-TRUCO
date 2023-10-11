package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Partida;
import com.tallerwebi.dominio.ServicioPartida;
import com.tallerwebi.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPartida {
    private ServicioPartida servicioPartida;

    @Autowired
    public ControladorPartida(ServicioPartida servicioPartida) {
        this.servicioPartida = servicioPartida;
    }

    @RequestMapping("/iniciarPartida")
    public void iniciarPartida(HttpServletRequest request,  String cantidadDejugadores){
       servicioPartida.crearPartida(new Partida((Usuario) request.getSession().getAttribute("usuario"), cantidadDejugadores));
    };

}
