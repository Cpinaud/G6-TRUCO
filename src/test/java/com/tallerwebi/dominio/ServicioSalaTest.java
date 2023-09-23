package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ControladorSala;
import org.junit.jupiter.api.BeforeEach;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;

public class ServicioSalaTest {


    private ControladorSala controladorSala;
    private Sala sala;
    private HttpServletRequest requestMock;
    private HttpSession sessionMock;
    private ServicioSalaImpl servicioSala;

    private RepositorioSala repositoriomock;
    @BeforeEach
    public void init(){
        sala = mock(Sala.class);
        requestMock = mock(HttpServletRequest.class);
        sessionMock = mock(HttpSession.class);
        repositoriomock = mock(RepositorioSala.class);
        servicioSala = new ServicioSalaImpl(repositoriomock);


    }
}

