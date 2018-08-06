package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {

    public void guardar(Usuario usuario);

    public Usuario buscar(int id);

    public List<Usuario> buscarTodos();

    public void darBaja(Usuario usuario);

}
