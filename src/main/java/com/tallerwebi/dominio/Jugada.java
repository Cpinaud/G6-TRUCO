package com.tallerwebi.dominio;

public class Jugada {

    private Long jugador;
    private Carta carta;

    public Jugada() {
    }

    public Jugada(Long jugador, Carta carta) {
        this.jugador = jugador;
        this.carta = carta;
    }

    public Long getJugador() {
        return jugador;
    }

    public void setJugador(Long jugador) {
        this.jugador = jugador;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }
}
