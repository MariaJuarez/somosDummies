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
    public String add(Metodologia metodologia) {
        metodologiaRepository.guardar(metodologia);
        return "";
    }

    @Override
    public List<Metodologia> buscarTodos() {
        return metodologiaRepository.buscar("");
    }

    @Override
    public Metodologia darBaja(int id) {
        Metodologia metodologia = metodologiaRepository.buscar(id);
        if (metodologia == null){
            return null;
        }
        return metodologiaRepository.darBaja(metodologia);
    }

    @Override
    public Metodologia buscar(int id) {
        return metodologiaRepository.buscar(id);
    }

    @Override
    public List<Metodologia> buscarNoBajas() {
        return metodologiaRepository.buscar("WHERE baja = false");
    }

    @Override
    public Metodologia editar(Metodologia metodologia) {
        if (metodologiaRepository.buscar(metodologia.getId()) == null){
            return null;
        }
        return metodologiaRepository.editar(metodologia);
    }
}
