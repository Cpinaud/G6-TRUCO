package com.tallerwebi.dominio;

import com.tallerwebi.dominio.Carta;
import com.tallerwebi.dominio.Palo;

import java.util.List;

public interface RepositorioCarta {
    List<Carta> obtenerCartas();
    void generarPalos();
    List<Palo> obtenerTodosLosPalos();
    void generarCartas();
}
