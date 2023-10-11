package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DatosLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service("servicioPartida")
@Transactional
public class ServicioPartida {



    private RepositorioPartida repositorioPartida;

    @Autowired
    public ServicioPartida(RepositorioPartida repositorioPartida){
        this.repositorioPartida = repositorioPartida;
    }


    public void crearPartida(Partida partida){
        repositorioPartida.crearPartida(partida);
    };
}
