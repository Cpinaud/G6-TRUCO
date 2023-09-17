package com.tallerwebi.dominio.jugador;

public interface RepositorioJugador {

    Jugador buscarJugador(String usuario, String contrasena);
    void guardar(Jugador jugador);
    Jugador buscar(String email);
    void modificar(Jugador jugador);
}
