package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioSala {

    Sala buscarsala(Long id);

    boolean Salaexistente(Long id);

    boolean guardarSala(Sala sala);

    List<Sala> obtenersalas();
}
