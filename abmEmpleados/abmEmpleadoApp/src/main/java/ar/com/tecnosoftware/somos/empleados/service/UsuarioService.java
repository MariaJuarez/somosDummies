package ar.com.tecnosoftware.somos.empleados.service;

import ar.com.tecnosoftware.somos.empleados.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public void addUsuario(Usuario usuario);

    public List<Usuario> buscarTodos();

    public void darBaja(Usuario usuario);

}
