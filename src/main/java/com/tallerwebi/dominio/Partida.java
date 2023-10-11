package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partida {

    Integer cantidadDejugadores;
    private List<Equipo> equipos;
    private List<Usuario> jugadores;
    private List<Ronda> rondas;

    
    public Partida(Usuario usuario, String cantidadDejugadores) {
        this.cantidadDejugadores = Integer.valueOf(cantidadDejugadores);
        equipos = new ArrayList<>();
        rondas = new ArrayList<>();
        jugadores = new ArrayList<>();
        jugadores.add(usuario);
        agregarEquipo(usuario);
    }

    private void agregarEquipo(Usuario usuario) {
        if(jugadores.size() == 1) equipos.add(new Equipo(1, usuario));
        else if(jugadores.size() == 2) equipos.add(new Equipo(2, usuario));
        else if(jugadores.size() == 3 || jugadores.size() == 5) equipos.get(1).agregarJugador(usuario);
        else if(jugadores.size() == 4 || jugadores.size() == 6) equipos.get(2).agregarJugador(usuario);
    }


    private void iniciarRonda(List<Carta> cartas) {
        rondas.add(new Ronda(equipos, jugadores));
    }
}