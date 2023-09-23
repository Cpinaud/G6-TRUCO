package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RepositorioSala;
import com.tallerwebi.dominio.Sala;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSalaImpl implements RepositorioSala {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioSalaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean crearsala(Long id, Integer Cantidad_maxima_jugadores) {
        if(!Salaexistente(id)){
            Sala sala = new Sala(id,Cantidad_maxima_jugadores,1);
            guardarSala(sala);
            return true;
        }
        return false;
    }
    @Override
    public boolean guardarSala(Sala sala) {
        if(!Salaexistente(sala.getId_sala())){
            sessionFactory.getCurrentSession().save(sala);
            return true;
        }
        return false;
    }
    @Override
    public boolean Salaexistente(Long id) {
        if (buscarsala(id)!=null){
            return true;
        }
        return false;
    }



    @Override
    public Sala buscarsala(Long id) {
        return (Sala) sessionFactory.getCurrentSession().createCriteria(Sala.class)
                .add(Restrictions.eq("id_sala", id))
                .uniqueResult();
    }

    public Sala obtenerSala(Long id){
        if (Salaexistente(id)){
            return buscarsala(id);
        }
        return null;
    }

}



