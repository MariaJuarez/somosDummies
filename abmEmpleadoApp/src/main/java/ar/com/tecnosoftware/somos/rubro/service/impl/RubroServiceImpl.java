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
    public Rubro darBaja(int id) {
        Rubro rubro = rubroRepository.buscar(id);
        if (rubro == null){
            return null;
        }
        return rubroRepository.darBaja(rubro);
    }

    @Override
    public Rubro buscar(int id) {
        return rubroRepository.buscar(id);
    }

    @Override
    public List<Rubro> buscarNoBajas() {
        return rubroRepository.buscar("WHERE baja = false");
    }

    @Override
    public Rubro editar(Rubro rubro) {
        if (rubroRepository.buscar(rubro.getId()) == null){
            return null;
        }

        return rubroRepository.editar(rubro);
    }
}
