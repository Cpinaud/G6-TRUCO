package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.RepositorioSala;
import com.tallerwebi.dominio.ServicioSala;
import com.tallerwebi.dominio.Sala;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorSalaTest {

    private ControladorSala controladorSala;
    private Sala sala;
    private HttpServletRequest requestMock;
    private HttpSession sessionMock;
    private ServicioSala servicioSalaMock;

    private RepositorioSala repositoriomock;
    @BeforeEach
    public void init(){
        sala = mock(Sala.class);
        requestMock = mock(HttpServletRequest.class);
        sessionMock = mock(HttpSession.class);
        servicioSalaMock = mock(ServicioSala.class);
        controladorSala = new ControladorSala(servicioSalaMock);


    }
}
