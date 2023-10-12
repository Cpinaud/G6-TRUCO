package com.tallerwebi.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sala;
    private Integer cantidadMaximaJugadores;
    private Integer Cantidad_de_jugadores_en_sala;


    public Sala(Long id, Integer cantidadMaximaJugadores) {
        this.id_sala =id;
        this.cantidadMaximaJugadores =cantidadMaximaJugadores;
        this.Cantidad_de_jugadores_en_sala = 1;

    }
    public Sala(Long id, Integer cantidadMaximaJugadores, Integer Cantidad_de_jugadores_en_sala) {
        this.id_sala =id;
        this.cantidadMaximaJugadores =cantidadMaximaJugadores;
        this.Cantidad_de_jugadores_en_sala =Cantidad_de_jugadores_en_sala;

    }

    public Sala(Integer cantidadMaximaJugadores, Integer Cantidad_de_jugadores_en_sala) {
        this.cantidadMaximaJugadores =cantidadMaximaJugadores;
        this.Cantidad_de_jugadores_en_sala =Cantidad_de_jugadores_en_sala;

    }
    public Sala() {
    }


    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public Integer getCantidadMaximaJugadores() {
        return cantidadMaximaJugadores;
    }

    public void setCantidadMaximaJugadores(Integer cantidadMaximaJugadores) {
        this.cantidadMaximaJugadores = cantidadMaximaJugadores;
    }

    public Integer getCantidad_de_jugadores_en_sala() {
        return Cantidad_de_jugadores_en_sala;
    }

    public void setCantidad_de_jugadores_en_sala(Integer cantidad_de_jugadores_en_sala) {
        Cantidad_de_jugadores_en_sala = cantidad_de_jugadores_en_sala;
    }
}
