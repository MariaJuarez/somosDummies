package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {

    public void guardar(Usuario usuario);

    public Usuario buscar(Usuario usuario);

    public List<Usuario> buscarTodos();

    public void darBaja(Usuario usuario);

}
