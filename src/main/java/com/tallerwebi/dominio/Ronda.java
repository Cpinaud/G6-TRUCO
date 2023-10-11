package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ronda {
    private List<Equipo> equipos;
    private List<Usuario> jugadores;
    private List<Carta> baraja; //hay que pasarle la baraja desde la base de datos;
    private List<Mano> manoDelJugador;
    private List<Carta> cartasEnLaMesa;


    public Ronda(List<Equipo> equipos, List<Usuario> jugadores) {
        this.equipos = equipos;
        this.jugadores = jugadores;
        cartasEnLaMesa = new ArrayList<>();
        repartir();
    }


    private void repartir() {

        Carta cartaAleatoria = baraja.get((int) Math.floor(Math.random()));
        baraja.remove(cartaAleatoria);

        for (int i = 0; i < jugadores.size(); i++) {
            List<Carta> cartasAleatorias = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                cartasAleatorias.add(cartaAleatoria);
            }
            manoDelJugador.add(new Mano (jugadores.get(i), cartasAleatorias));
        }
    }

    public void jugarCarta(Usuario usuario, Carta carta){
        cartasEnLaMesa.add(carta);
    }

    public void terminarMano(){
        Usuario  ganador = calcularGanador();
        ordenarJugadores(ganador);
    }

    private void ordenarJugadores(Usuario ganador) {
        int indiceGanador = jugadores.indexOf(ganador);

        if (indiceGanador >= 0) {
            List<Usuario> subListaAntes = jugadores.subList(0, indiceGanador);
            List<Usuario> subListaDespues = jugadores.subList(indiceGanador + 1, jugadores.size());

            jugadores.clear();

            jugadores.addAll(subListaDespues);
            jugadores.add(0, ganador);
            jugadores.addAll(subListaAntes);
        }
    }

    private Usuario calcularGanador() {
        Carta cartaMayor = cartasEnLaMesa.get(0);

        for (int i = 1; i < cartasEnLaMesa.size(); i++) {
            if(cartasEnLaMesa.get(i).getValor() > cartaMayor.getValor()){
                cartaMayor = cartasEnLaMesa.get(i);
            }
        }

        return jugadores.get(cartasEnLaMesa.indexOf(cartaMayor));
    }

}
