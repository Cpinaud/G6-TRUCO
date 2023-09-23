package com.tallerwebi.dominio;

public interface RepositorioSala {

    boolean crearsala(Long id, Integer Cantidad_maxima_jugadores);
    Sala buscarsala(Long id);

    boolean Salaexistente(Long id);

    boolean guardarSala(Sala sala);

    Sala obtenerSala(Long id);

}
