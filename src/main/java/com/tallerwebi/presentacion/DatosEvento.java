package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Usuario;

public class DatosEvento {
    Usuario usuariocanta;
    Usuario usuariodecide;
    EventoPartida eventoPartida;
    Boolean quiero;

    public Usuario getUsuariocanta() {
        return usuariocanta;
    }

    public void setUsuariocanta(Usuario usuariocanta) {
        this.usuariocanta = usuariocanta;
    }

    public Usuario getUsuariodecide() {
        return usuariodecide;
    }

    public void setUsuariodecide(Usuario usuariodecide) {
        this.usuariodecide = usuariodecide;
    }

    public EventoPartida getEventoPartida() {
        return eventoPartida;
    }

    public void setEventoPartida(EventoPartida eventoPartida) {
        this.eventoPartida = eventoPartida;
    }

    public Boolean getQuiero() {
        return quiero;
    }

    public void setQuiero(Boolean quiero) {
        this.quiero = quiero;
    }
}
