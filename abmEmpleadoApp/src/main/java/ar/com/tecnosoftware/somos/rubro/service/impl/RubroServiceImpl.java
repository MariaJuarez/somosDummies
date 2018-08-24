package ar.com.tecnosoftware.somos.rubro.service.impl;

import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.rubro.repository.RubroRepository;
import ar.com.tecnosoftware.somos.rubro.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RubroServiceImpl implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public void add(Rubro rubro) {
        rubroRepository.guardar(rubro);
    }

    @Override
    public List<Rubro> buscarTodos() {
        return rubroRepository.buscar("");
    }

    @Override
    public void darBaja(int id) {
        rubroRepository.darBaja(rubroRepository.buscar(id));
    }

    @Override
    public Rubro buscar(int id) {
        return rubroRepository.buscar(id);
    }

    @Override
    public List<Rubro> buscarNoBajas() {
        return rubroRepository.buscar("WHERE baja = false");
    }
}
