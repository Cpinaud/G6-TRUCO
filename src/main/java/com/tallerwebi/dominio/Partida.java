package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Partida {

    Integer cantidadDejugadores;
    private List<Equipo> equipos;
    private List<Usuario> jugadores;
    private List<Ronda> rondas;

    
    public Partida(Usuario usuario, Integer cantidadDejugadores) {
        this.cantidadDejugadores = cantidadDejugadores;
        equipos = new ArrayList<>();
        rondas = new ArrayList<>();
        jugadores = new ArrayList<>();
        agregarEquipo(usuario);
    }

    public void agregarEquipo(Usuario usuario) {
        jugadores.add(usuario);
        if(jugadores.size() == 1) equipos.add(new Equipo(1, usuario));
        else if(jugadores.size() == 2) equipos.add(new Equipo(2, usuario));
        else if(jugadores.size() == 3 || jugadores.size() == 5) equipos.get(1).agregarJugador(usuario);
        else if(jugadores.size() == 4 || jugadores.size() == 6) equipos.get(2).agregarJugador(usuario);
    }


    public void iniciarRonda(List<Carta> cartas) {
        rondas.add(new Ronda(equipos, jugadores, cartas));
    }

    public int obtenerCantidadDeJugadores() {
        return jugadores.size();
    }

    public Ronda obtenerRondaActual() {
        return rondas.get(rondas.size()-1);
    }

    public boolean buscarUsuario(Usuario usuario) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId().equals(usuario.getId())) return true;
        }
        return false;
    }
}