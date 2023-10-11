package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private int id;
    private List<Equipo> equipos;


    public Partida(int id, Equipo equipos) {
        this.id = id;
        this.equipos = new ArrayList<>();
    }
}