package com.tallerwebi.dominio;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RondaTest {



    @Test
    public void queUnaRodnaContengaJugadores(){

        Usuario usuario1= new Usuario();
        Usuario usuario2= new Usuario();

        List <Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        List <Carta> cartas = new ArrayList<>();
        cartas.add()



        Ronda ronda = new Ronda( usuarios ,  cartas);

    }
}
