package com.tallerwebi.dominio;
import com.tallerwebi.integracion.config.HibernateTestConfig;
import com.tallerwebi.integracion.config.SpringWebTestConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebTestConfig.class, HibernateTestConfig.class})
public class RepositorioCartaTest {

    @Autowired
    private RepositorioCarta repositorioCarta;

    @Transactional
    @Rollback
    @Test
    public void queSeCreenLosPalos() {

        repositorioCarta.generarPalos();
        System.out.println("repositorioCarta en el test = "+ repositorioCarta);
        List<Palo> resultado = repositorioCarta.obtenerTodosLosPalos();
        System.out.println(resultado);

        assertEquals(4, resultado.size());
    }
    @Test
    @Transactional
    @Rollback
    public void testLongitudDeBaraja() {

        repositorioCarta.generarCartas();
        List<Carta> resultado = repositorioCarta.obtenerCartas();


        assertEquals(40, resultado.size());
    }
}







