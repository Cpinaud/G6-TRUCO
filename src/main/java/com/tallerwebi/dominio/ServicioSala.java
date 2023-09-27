package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioSala {

    boolean crearsala(Sala sala);


    Sala obtenersala(Long id);

    List<Sala> obtenerlistadeSalas();
}
