package ar.com.tecnosoftware.somos.metodologia.service.impl;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.metodologia.repository.MetodologiaRepository;
import ar.com.tecnosoftware.somos.metodologia.service.MetodologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MetodologiaServiceImpl implements MetodologiaService {

    @Autowired
    private MetodologiaRepository metodologiaRepository;

    @Override
    public void add(Metodologia metodologia) {
        metodologiaRepository.guardar(metodologia);
    }

    @Override
    public List<Metodologia> buscarTodos() {
        return metodologiaRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        metodologiaRepository.darBaja(metodologiaRepository.buscar(id));
    }

    @Override
    public Metodologia buscar(int id) {
        return metodologiaRepository.buscar(id);
    }
}
