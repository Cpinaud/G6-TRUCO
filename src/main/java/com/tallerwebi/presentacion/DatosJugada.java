package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Carta;

public class DatosJugada {

    private Long jugador;
    private Integer carta;

    public DatosJugada(){

    }
    public DatosJugada(Long jugador, Integer carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

    public Long getJugador() {
        return jugador;
    }

    public void setJugador(Long jugador) {
        this.jugador = jugador;
    }

    public Integer getCarta() {
        return carta;
    }

    public void setCarta(Integer carta) {
        this.carta = carta;
    }
}
