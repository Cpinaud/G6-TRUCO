package com.tallerwebi.infraestructura;
import com.tallerwebi.dominio.Carta;
import com.tallerwebi.dominio.Palo;
import com.tallerwebi.dominio.RepositorioCarta;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RepositorioCartaImpl implements RepositorioCarta {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCartaImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void generarPalos() {
        sessionFactory.getCurrentSession().save(new Palo("oro"));
        sessionFactory.getCurrentSession().save(new Palo("espada"));
        sessionFactory.getCurrentSession().save(new Palo("copa"));
        sessionFactory.getCurrentSession().save(new Palo("basto"));

    }
    @Transactional
    public List<Palo> obtenerTodosLosPalos() {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("SESSION DE obtenerTodosLosPalos()= " + session);
        Criteria criteria = session.createCriteria(Palo.class);
        System.out.println("Consulta scriteria = " + criteria);
        List<Palo> palos = criteria.list();
        System.out.println("QUERY DE obtenerTodosLosPalos()= " + palos);
        return palos;
    }
    @Transactional
    public Palo obtenerPalo(int paloId) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("SESION EN EL METODO  obtenerPalo(int palo) = " + session);
        Query<Palo> query = session.createQuery("SELECT p FROM Palo p WHERE p.id = :paloId", Palo.class);
        query.setParameter("paloId", paloId);
        return query.uniqueResult();
    }

    @Transactional
    public List<Carta> obtenerCartas() {
        Session session = sessionFactory.getCurrentSession();
        List<Carta> baraja =  session.createCriteria(Carta.class).list();
        return baraja;

    }

    @Transactional
    public void generarCartas() {
        Session session = sessionFactory.getCurrentSession();
        generarPalos();
        Palo paloOro = obtenerPalo(1); // 1 representa el palo de oro
        Palo paloEspada = obtenerPalo(2); // 2 representa el palo de espada
        Palo paloCopa = obtenerPalo(3); // 3 representa el palo de copa
        Palo paloBasto = obtenerPalo(4); // 4 representa el palo de basto


        // Cartas de Oro
        session.save(new Carta(1, paloOro, 8, "oro1.png"));
        session.save(new Carta(2, paloOro, 9, "oro2.png"));
        session.save(new Carta(3, paloOro, 10, "oro3.png"));
        session.save(new Carta(4, paloOro, 1, "oro4.png"));
        session.save(new Carta(5, paloOro, 2, "oro5.png"));
        session.save(new Carta(6, paloOro, 3, "oro6.png"));
        session.save(new Carta(7, paloOro, 11, "oro7.png"));
        session.save(new Carta(10, paloOro, 5, "oro10.png"));
        session.save(new Carta(11, paloOro, 6, "oro11.png"));
        session.save(new Carta(12, paloOro, 7, "oro12.png"));

        // Cartas de Espada
        session.save(new Carta(1, paloEspada, 8, "espada1.png"));
        session.save(new Carta(2, paloEspada, 9, "espada2.png"));
        session.save(new Carta(3, paloEspada, 10, "espada3.png"));
        session.save(new Carta(4, paloEspada, 1, "espada4.png"));
        session.save(new Carta(5, paloEspada, 2, "espada5.png"));
        session.save(new Carta(6, paloEspada, 3, "espada6.png"));
        session.save(new Carta(7, paloEspada, 11, "espada7.png"));
        session.save(new Carta(10, paloEspada, 5, "espada10.png"));
        session.save(new Carta(11, paloEspada, 6, "espada11.png"));
        session.save(new Carta(12, paloEspada, 7, "espada12.png"));

        // Cartas de Copa
        session.save(new Carta(1, paloCopa, 8, "copa1.png"));
        session.save(new Carta(2, paloCopa, 9, "copa2.png"));
        session.save(new Carta(3, paloCopa, 10, "copa3.png"));
        session.save(new Carta(4, paloCopa, 1, "copa4.png"));
        session.save(new Carta(5, paloCopa, 2, "copa5.png"));
        session.save(new Carta(6, paloCopa, 3, "copa6.png"));
        session.save(new Carta(7, paloCopa, 4, "copa7.png"));
        session.save(new Carta(10, paloCopa, 5, "copa10.png"));
        session.save(new Carta(11, paloCopa, 6, "copa11.png"));
        session.save(new Carta(12, paloCopa, 7, "copa12.png"));

        // Cartas de Basto
        session.save(new Carta(1, paloBasto, 8, "basto1.png"));
        session.save(new Carta(2, paloBasto, 9, "basto2.png"));
        session.save(new Carta(3, paloBasto, 10, "basto3.png"));
        session.save(new Carta(4, paloBasto, 1, "basto4.png"));
        session.save(new Carta(5, paloBasto, 2, "basto5.png"));
        session.save(new Carta(6, paloBasto, 3, "basto6.png"));
        session.save(new Carta(7, paloBasto, 11, "basto7.png"));
        session.save(new Carta(10, paloBasto, 5, "basto10.png"));
        session.save(new Carta(11, paloBasto, 6, "basto11.png"));
        session.save(new Carta(12, paloBasto, 7, "basto12.png"));
    }



}

