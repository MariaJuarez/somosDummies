package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entityoOld.Usuario;

import java.util.List;

public interface UsuarioService {

    public void addUsuario(Usuario usuario);

    public List<Usuario> buscarTodos();

    public void darBaja(Usuario usuario);

}
