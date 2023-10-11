package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private List<Equipo> equipos;

    
    public Partida(Usuario usuario) {
        equipos = new ArrayList<>();
        agregarEquipo(usuario);
    }

    private void agregarEquipo(Usuario usuario) {


        if(equipos.get(0) == null){
            equipos.get(0).agregarJugador(usuario);
        }else{
            equipos.get(1).agregarJugador(usuario);
        }

    }
}