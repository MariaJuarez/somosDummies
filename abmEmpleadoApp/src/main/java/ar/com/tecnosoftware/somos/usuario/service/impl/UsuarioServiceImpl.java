package ar.com.tecnosoftware.somos.usuario.service.impl;

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
    public void darBaja(int id) {
        usuarioRepository.darBaja(usuarioRepository.buscar(id));
    }

    @Override
    public Usuario buscarUsuarioConEmpleado(int idEmpleado) {
        return usuarioRepository.buscarUsuarioConEmpleado(idEmpleado);
    }

    @Override
    public void darBajaEmpleadoDeUsuario(Usuario usuario) {
        usuarioRepository.darBajaEmpleadoDeUsuario(usuario, empleadoRepository.buscar(1));
    }

    @Override
    public void editar(Usuario usuario) {
        if (usuarioRepository.buscar(usuario.getId()) == null){
            return;
        }
        usuarioRepository.editar(usuario);
    }
}
