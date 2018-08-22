package ar.com.tecnosoftware.somos.perfil.service.impl;

import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.repository.PerfilRepository;
import ar.com.tecnosoftware.somos.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public void add(Perfil perfil) {
        perfilRepository.guardar(perfil);
    }

    @Override
    public List<Perfil> buscarTodos() {
        return perfilRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        perfilRepository.darBaja(perfilRepository.buscar(id));
    }

    @Override
    public Perfil buscar(int id) {
        return perfilRepository.buscar(id);
    }
}
