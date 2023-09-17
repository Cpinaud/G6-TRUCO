package com.tallerwebi.dominio.jugador;


public interface ServicioIngreso {

    Jugador buscarJugador(String usuario) ;
    void agregarJugador(String nombre, String apellido, String usuario, String contrasena) ;
    
}
