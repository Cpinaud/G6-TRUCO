package com.tallerwebi.presentacion;

import javax.persistence.Entity;
import javax.persistence.Id;


public enum EventoPartida {

    truco,retruco,vale_cuatro,envido,real_envido,falta_envido;


  /*
  Agregar entity y cambiar a class

    @Id
    private Long id;
    private String nombre_evento;
    private Integer valor;



    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }*/
}
