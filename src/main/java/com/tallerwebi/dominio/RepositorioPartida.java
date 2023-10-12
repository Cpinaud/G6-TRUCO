package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioPartida {


    void crearPartida(Usuario usuario, int cantidadJugadoresInt);
    List<Carta> obtenerManoDelJugador(Long usuario);

    Integer obtenerCantidadDeJugadores();
}
