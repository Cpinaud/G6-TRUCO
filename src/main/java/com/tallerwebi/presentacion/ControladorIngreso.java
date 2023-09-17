package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.jugador.ServicioIngreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIngreso {

    public ServicioIngreso servicioIngreso;

    @Autowired
    public ControladorIngreso(ServicioIngreso servicioIngreso){
        this.servicioIngreso = servicioIngreso;
    }

    @RequestMapping("/index")
    public ModelAndView irAIngreso() {

        ModelMap modelo = new ModelMap();
        modelo.put("datosDeIngreso", new DatosDeIngreso());
        return new ModelAndView("index", modelo);
    }
    @RequestMapping(path = "/validar-ingreso", method = RequestMethod.POST)
    public ModelAndView validarIngreso(@ModelAttribute("datosDeIngreso") DatosDeIngreso datosDeIngreso) {
        ModelMap modelo = new ModelMap();

        if (datosDeIngreso.getUsuario() != null) {
            return new ModelAndView("redirect:/singin");
        } else {
            modelo.put("error", "Usuario o clave incorrecta");
        }
        return new ModelAndView("login", modelo);
    }

    @RequestMapping(path = "/singin", method = RequestMethod.GET)
    public ModelAndView irASingin() {
        return new ModelAndView("singin");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView inicio() {
        return new ModelAndView("redirect:/index");
    }


}
