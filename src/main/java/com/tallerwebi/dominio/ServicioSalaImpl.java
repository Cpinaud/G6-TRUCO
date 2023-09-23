package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioSalaImpl implements ServicioSala {
        private RepositorioSala serviciosalaDao;


    @Autowired
    public ServicioSalaImpl(RepositorioSala serviciosalaDao){
            this.serviciosalaDao = serviciosalaDao;
        }

    }

