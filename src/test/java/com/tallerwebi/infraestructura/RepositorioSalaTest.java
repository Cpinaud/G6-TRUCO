package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RepositorioSala;
import com.tallerwebi.dominio.RepositorioUsuario;
import com.tallerwebi.dominio.Sala;
import com.tallerwebi.dominio.ServicioSalaImpl;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import com.tallerwebi.presentacion.ControladorSala;
import org.hibernate.SessionFactory;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})
public class RepositorioSalaTest {


    @Autowired
    SessionFactory sessionFactory;

    private RepositorioSalaImpl repositorio;
    @BeforeEach
    public void init(){
        repositorio = new RepositorioSalaImpl(sessionFactory);

    }

    @Test
    @Transactional
    @Rollback
    public void QueSePuedaCrearUnaSala() {

        repositorio.crearsala(1L,2);

        Long valoresperado= 1L;

        assertEquals(valoresperado,repositorio.obtenerSala(1L).getId_sala());


    }

    @Test
    @Transactional
    @Rollback
    public void QueSePuedaGuardarUnaSala() {
        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);

        repositorio.guardarSala(sala);

        Long valoresperado= 1L;
        assertEquals(valoresperado,repositorio.obtenerSala(1L).getId_sala());


    }
    @Test
    @Transactional
    @Rollback
    public void QueDevuelvaFalsoAlIntentarCrearUnaSalaYaExistenteConUnMismoid() {

        repositorio.crearsala(1L,2);

        assertFalse(repositorio.crearsala(1L, 2));


    }

    @Test
    @Transactional
    @Rollback
    public void QueDevuelvaFalsoAlIntentarGuardarUnaSalaYaExistenteConUnMismoid() {

        Sala sala=new Sala();
        sala.setId_sala(1L);
        sala.setCantidadMaximaJugadores(2);
        sala.setCantidad_de_jugadores_en_sala(1);

        repositorio.guardarSala(sala);

        assertFalse(repositorio.guardarSala(sala));


    }

}
