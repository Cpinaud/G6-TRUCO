package com.tallerwebi.dominio;

public class MensajeRecibido {

    private String message;
    private Long usuarioId;

    public MensajeRecibido() {
    }

    public MensajeRecibido(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

}
