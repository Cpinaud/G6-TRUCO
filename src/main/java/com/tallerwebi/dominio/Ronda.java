package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private List<Equipo> equipos;
    private List<Usuario> jugadores;
    private List<Carta> baraja; //hay que pasarle la baraja desde la base de datos;
    private List<Mano> manoDelJugador;
    private List<Carta> cartasEnLaMesa;


    public Ronda(List<Equipo> equipos, List<Usuario> jugadores, List<Carta> baraja) {
        this.equipos = equipos;
        this.jugadores = jugadores;
        this.baraja = baraja;
        manoDelJugador = new ArrayList<>();
        cartasEnLaMesa = new ArrayList<>();
        repartir();
    }


    private void repartir() {

        for (int i = 0; i < jugadores.size(); i++) {
            List<Carta> cartasAleatorias = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int indiceRandom = (int) (Math.random() * baraja.size());
                Carta cartaAleatoria = baraja.get(indiceRandom);

                cartasAleatorias.add(cartaAleatoria);
                baraja.remove(cartaAleatoria);
            }
            manoDelJugador.add(new Mano (jugadores.get(i), cartasAleatorias));
        }
    }

    public void jugarCarta(Usuario usuario, Carta carta){
        if (!validarSiYaTiroCarta(usuario)) {
            cartasEnLaMesa.add(carta);
            if (validarSiTerminoMano()) {
                terminarMano();
            }
        }

    }

    private boolean validarSiYaTiroCarta(Usuario usuario) {
        for (int i = 0; i < manoDelJugador.size(); i++) {
           if( manoDelJugador.get(i).getJugador() == usuario) return true;
        }
        return false;
    }

    private boolean validarSiTerminoMano() {
        return manoDelJugador.size() == jugadores.size();
    };

    public void terminarMano(){
        Usuario  ganador = calcularGanador();
        manoDelJugador.clear();
        ordenarJugadores(ganador);
        repartir();
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

    public List<Carta> getBaraja() {
        return baraja;
    }

    public List<Mano> getManoDelJugador() {
        return manoDelJugador;
    }

    public List<Carta> getCartasEnLaMesa() {
        return cartasEnLaMesa;
    }

    public boolean validarSiLaRondaTermino() {
        return cartasEnLaMesa.size() == jugadores.size() * 3;
    }
}
