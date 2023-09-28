package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ControladorSala;
import org.hsqldb.lib.HsqlArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioSalaTest {


    private ControladorSala controladorSala;
    private Sala sala;
    private HttpServletRequest requestMock;
    private HttpSession sessionMock;
    private ServicioSalaImpl servicioSala;
    private ServicioSala servicioSalamock;
    private RepositorioSala repositoriomock;
    @BeforeEach
    public void init(){

        requestMock = mock(HttpServletRequest.class);
        sessionMock = mock(HttpSession.class);
        repositoriomock = mock(RepositorioSala.class);
        servicioSala = new ServicioSalaImpl(repositoriomock);
        servicioSalamock = mock(ServicioSala.class);

    }

    @Test
    public void QueObtengaunaSalaPorID(){

        Sala sala = new Sala(1L,2,1);
        when(servicioSalamock.obtenersala(1L)).thenReturn(sala);


        assertEquals(1L,servicioSalamock.obtenersala(1L).getId_sala());

    }
    @Test
    public void QueCreeunaSalaRecibiendounaSala(){

        Sala sala = new Sala(1L,2,1);
        when(servicioSalamock.obtenersala(1L)).thenReturn(sala);
        servicioSalamock.crearsala(sala);

        assertEquals(sala.getId_sala(),servicioSalamock.obtenersala(1L).getId_sala());

    }

    @Test
    public void QueObtengaunaListadeSalas(){

        Sala sala = new Sala(1L,2,1);
        Sala sala2 = new Sala(2L,2,1);
        ArrayList<Sala> salas=  new ArrayList<Sala>();
        salas.add(sala);
        salas.add(sala2);
        when(servicioSalamock.obtenerlistadeSalas()).thenReturn(salas);
        servicioSalamock.crearsala(sala);

        assertEquals(2,servicioSalamock.obtenerlistadeSalas().size());

    }







}

