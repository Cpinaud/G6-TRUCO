package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.*;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import com.tallerwebi.presentacion.ControladorSala;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})
public class RepositorioSalaTest {


    @Autowired
    SessionFactory sessionFactory;
    private RepositorioSala repositorio;



    @BeforeEach
    public void init(){
        repositorio = new RepositorioSalaImpl(sessionFactory);

    }

    @Transactional
    @Rollback
    @Test
    public void QueSePuedaGuardarUnaSala() {
        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);

        assertTrue(repositorio.guardarSala(sala));


    }

    @Transactional
    @Rollback
    @Test
    public void QueBusqueUnaSalaPorId() {
        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);
        repositorio.guardarSala(sala);

        assertEquals(1L,repositorio.buscarsala(1L).getId_sala());


    }

    @Transactional
    @Rollback
    @Test
    public void QueDevuelvaFalsoAlIntentarGuardarUnaSalaYaExistenteConUnMismoid() {

        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);

        Sala sala2=new Sala();
        sala2.setId_sala(1L);
        sala2.setCantidadMaximaJugadores(2);
        sala2.setCantidad_de_jugadores_en_sala(1);

        repositorio.guardarSala(sala);

        assertFalse(repositorio.guardarSala(sala2));


    }


    @Test
    @Transactional
    @Rollback
    public void QuesePuedaObtenerlaListadeSalas() {

        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);

        Sala sala2 =new Sala();
        sala2.setId_sala(2L);
        sala2.setCantidadMaximaJugadores(2);
        sala2.setCantidad_de_jugadores_en_sala(1);

        repositorio.guardarSala(sala);
        repositorio.guardarSala(sala2);

        List<Sala> salas=repositorio.obtenersalas();

        assertEquals(salas.size(),2);


    }







}
