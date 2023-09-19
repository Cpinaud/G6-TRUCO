package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Jugador;
import com.tallerwebi.dominio.RepositorioJugador;
import org.springframework.stereotype.Repository;

@Repository("repositorioJugador")
public class RepositorioJugadorImpl implements RepositorioJugador {
    @Override
    public Jugador buscarJugador(String usuario, String contrasena) {
        return null;
    }

    @Override
    public void guardar(Jugador jugador) {

    }

    @Override
    public Jugador buscar(String email) {
        return null;
    }

    @Override
    public void modificar(Jugador jugador) {

    }
}
