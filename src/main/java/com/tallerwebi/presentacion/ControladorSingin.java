package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSingin {
    private ServicioLogin servicioLogin;

    @Autowired
    public ControladorSingin(ServicioLogin servicioLogin){
        this.servicioLogin = servicioLogin;
    }



}
