package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.DatosLogin;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;

@Service("servicioPartida")
@Transactional
public class ServicioPartida {





    public void crearPartida(@ModelAttribute("datosLogin") DatosLogin datosLogin) {

    }
}
