package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public void addUsuario(Usuario usuario);

    public List<Usuario> buscarTodos();

    public void darBaja(int id);

}
