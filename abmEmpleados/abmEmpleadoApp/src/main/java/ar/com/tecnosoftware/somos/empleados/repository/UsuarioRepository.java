package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.Usuario;

public interface UsuarioRepository {

    public void guardar(Usuario usuario);

    public Usuario buscar(Usuario usuario);

}
