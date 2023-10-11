package com.tallerwebi.dominio;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPartida")
public class RepositorioPartidaImpl implements RepositorioPartida{


    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPartidaImpl(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory;}


    @Override
    public void crearPartida(Partida partida) {
        sessionFactory.save(partida);
    }
}
