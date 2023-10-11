package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPartida")
public class RepositorioPartidaImpl implements RepositorioPartida {


    private SessionFactory sessionFactory;

    private Partida partida;

    @Autowired
    public RepositorioPartidaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }


    @Override
    public void crearPartida(Usuario usuario, int cantidadJugadoresInt) {

        if (partida == null) partida = new Partida(usuario, cantidadJugadoresInt);
        else if(partida.buscarUsuario(usuario) == false) partida.agregarEquipo(usuario);

        if (cantidadJugadoresInt == partida.obtenerCantidadDeJugadores()) {
            partida.iniciarRonda(obtenerBaraja());
        }
    }

    private List<Carta> obtenerBaraja() {
        return sessionFactory.getCurrentSession().createQuery("FROM Carta", Carta.class).list();
    }

    public List<Carta> obtenerManoDelJugador(Usuario usuario){
        List<Mano> manos = partida.obtenerRondaActual().getManoDelJugador();

        for (int i = 0; i < manos.size(); i++) {
            if (manos.get(i).getJugador() == usuario){

                return manos.get(i).getCartasEnLaMano();
            }
        }
        return null;
    }

    @Override
    public Integer obtenerCantidadDeJugadores() {
        return partida.obtenerCantidadDeJugadores();
    }
}
