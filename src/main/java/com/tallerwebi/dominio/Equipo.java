package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private int id;

    private int puntos;

    private List<Usuario> jugadores;

    public Equipo(int id, int puntos, List<Usuario> jugadores) {
        this.id = id;
        this.puntos = puntos;
        this.jugadores  = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getPuntos() {
        return puntos;
    }

    public List<Usuario> getJugadores() {
        return jugadores;


    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }

    public void agregarJugador(Usuario jugador) {
        jugadores.add(jugador);
    }
}
