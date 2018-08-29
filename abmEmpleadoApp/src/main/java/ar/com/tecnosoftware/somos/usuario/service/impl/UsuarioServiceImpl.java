package ar.com.tecnosoftware.somos.usuario.service.impl;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.empleado.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.usuario.repository.UsuarioRepository;
import ar.com.tecnosoftware.somos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void add(Usuario usuario) {
        usuario.setEmpleado(empleadoRepository.buscar(usuario.getEmpleado().getId()));
        usuarioRepository.guardar(usuario);
    }

    @Override
    public Usuario buscar(int id) {
        return usuarioRepository.buscar(id);
    }

    @Override
    public List<Usuario> buscarNoBajas() {
        return usuarioRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.buscar("");
    }

    @Override
    public Usuario darBaja(int id) {
        Usuario usuario = usuarioRepository.buscar(id);
        if(usuario == null){
            return null;
        }
        return usuarioRepository.darBaja(usuario);
    }

    @Override
    public Usuario buscarUsuarioConEmpleado(int idEmpleado) {
        return usuarioRepository.buscarUsuarioConEmpleado(idEmpleado);
    }

    @Override
    public Boolean darBajaEmpleadoDeUsuario(Usuario usuario) {
        Empleado empleado = empleadoRepository.buscar(1);
        if(empleado == null){
            return false;
        }

        if(usuarioRepository.darBajaEmpleadoDeUsuario(usuario, empleado) == null){
            return false;
        }
        return true;
    }

    @Override
    public Usuario editar(Usuario usuario) {
        if (usuarioRepository.buscar(usuario.getId()) == null){
            return null;
        }
        return usuarioRepository.editar(usuario);
    }
}
