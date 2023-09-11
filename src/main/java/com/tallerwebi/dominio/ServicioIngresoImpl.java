package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServicioIngresoImpl implements ServicioIngreso{

    ArrayList<Jugador>jugadores;

    public ServicioIngresoImpl(){
        jugadores = new ArrayList<>();
        generarJugadores();
    }
    @Override
    public Jugador buscarJugador(String usuario) {
        return null;
    }

    @Override
    public void agregarJugador(String nombre, String apellido, String usuario, String contrasena) {
        jugadores.add(new Jugador(nombre,apellido,usuario,contrasena));
    }

    public void generarJugadores() {
        jugadores.add(new Jugador("Rocio", "Crespo", "userRocio", "1234"));
        jugadores.add(new Jugador("Rodrigo", "Monteagudo", "userRodrigo", "1234"));
        jugadores.add(new Jugador("Cintia", "Pinaud", "userCintia", "1234"));
        jugadores.add(new Jugador("Alejandro", "Rios", "userAle", "1234"));
    }
}
