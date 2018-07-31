package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Usuario;
import ar.com.tecnosoftware.somos.empleados.repository.UsuarioRepository;
import ar.com.tecnosoftware.somos.empleados.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void addUsuario(Usuario usuario) {
        usuarioRepository.guardar(usuario);
    }
}
