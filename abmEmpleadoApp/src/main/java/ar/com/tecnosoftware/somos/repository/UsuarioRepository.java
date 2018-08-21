package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Usuario;

public interface UsuarioRepository extends Repository<Usuario> {

    Usuario buscarUsuarioConEmpleado(int idEmpleado);

    void darBajaEmpleadoDeUsuario(Usuario usuario, Empleado empleado);

}
