package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.UsuarioExistente;

public interface ServicioLogin {

    Usuario consultarUsuario(String email, String password);
    //Jugador buscarUsuario(String usuario, String contrasena);
    void registrar(Usuario usuario) throws UsuarioExistente;

}
