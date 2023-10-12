package com.tallerwebi.dominio;

public class MensajeEnviado {
    private String content;
    private Boolean usuario;


    public MensajeEnviado(String content, Boolean usuario) {
        this.content = content;
        this.usuario = usuario;
    }

    public Boolean getUsuario() {
        return usuario;
    }

    public void setUsuario(Boolean usuario) {
        this.usuario = usuario;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
