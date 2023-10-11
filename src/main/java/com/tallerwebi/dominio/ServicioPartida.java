package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("servicioPartida")
@Transactional
public class ServicioPartida {



    private RepositorioPartida repositorioPartida;

    @Autowired
    public ServicioPartida(RepositorioPartida repositorioPartida){
        this.repositorioPartida = repositorioPartida;
    }


    public void crearPartida(Usuario usuario, int cantidadJugadoresInt){
        repositorioPartida.crearPartida(usuario, cantidadJugadoresInt);
    };

    public List<Carta> obtenerManoDelJugador(Usuario usuario){
        return repositorioPartida.obtenerManoDelJugador(usuario);
    };

    public Integer obtenerCantDeJugadores(){
        return repositorioPartida.obtenerCantidadDeJugadores();
    }
}
