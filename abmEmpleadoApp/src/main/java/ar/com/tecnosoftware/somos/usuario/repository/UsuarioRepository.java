package ar.com.tecnosoftware.somos.usuario.repository;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.usuario.entity.Usuario;

public interface UsuarioRepository extends Repository<Usuario> {

    Usuario buscarUsuarioConEmpleado(int idEmpleado);

    Usuario darBajaEmpleadoDeUsuario(Usuario usuario, Empleado empleado);

}
