package com.tallerwebi.integracion;
import com.tallerwebi.dominio.Jugador;
import com.tallerwebi.dominio.ServicioIngreso;
import com.tallerwebi.dominio.ServicioIngresoImpl;
import com.tallerwebi.presentacion.ControladorIngreso;
import com.tallerwebi.presentacion.DatosDeIngreso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


public class ControladorIngresoTest {

	private Jugador jugadorMock;
	private DatosDeIngreso datosDeIngresoMock;
	private ServicioIngreso servicioIngresoMock;
	private ControladorIngreso controladorIngreso;


	@BeforeEach
	public void init(){
		datosDeIngresoMock = new DatosDeIngreso("usuario1", "123");
		jugadorMock = mock(Jugador.class);
		when(jugadorMock.getUsuario()).thenReturn("usuario1");

		servicioIngresoMock = mock(ServicioIngreso.class);
		controladorIngreso = new ControladorIngreso(servicioIngresoMock);

	}

	@Test
	public void queSePuedaRegistrarUnJugador(){
		// preparacion

		// ejecucion


		// validacion

	assertTrue(true);
	}

}
