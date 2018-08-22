package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.usuario.entity.Usuario;
import ar.com.tecnosoftware.somos.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.repository.UsuarioRepository;
import ar.com.tecnosoftware.somos.service.UsuarioService;
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
    public List<Usuario> buscarTodos() {
        return usuarioRepository.buscarTodos();
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
}
