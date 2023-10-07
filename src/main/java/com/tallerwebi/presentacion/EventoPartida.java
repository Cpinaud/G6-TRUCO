package com.tallerwebi.presentacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EventoPartida {


    private String evento;

    private Integer valor;
    public EventoPartida(){
    }
    public EventoPartida(String evento){
        this.evento=evento;
    }

    public EventoPartida(String evento, Integer valor) {
        this.evento=evento;
        this.valor=valor;
    }

    public String getevento() {
        return evento;
    }

    public void setevento(String nombre_evento) {
        this.evento = nombre_evento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }



}
