package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.repository.TecnologiaRepository;
import ar.com.tecnosoftware.somos.repository.TipoTecnologiaRepository;
import ar.com.tecnosoftware.somos.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TecnologiaServiceImpl implements TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private TipoTecnologiaRepository tipoTecnologiaRepository;

    @Override
    public void add(Tecnologia tecnologia) {
        tecnologia.setTipoTecnologia(tipoTecnologiaRepository.buscar(tecnologia.getTipoTecnologia().getIdTipoTecnologia()));
        tecnologiaRepository.guardar(tecnologia);
    }

    @Override
    public List<Tecnologia> buscarTodos() {
        return tecnologiaRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        tecnologiaRepository.darBaja(tecnologiaRepository.buscar(id));
    }

    @Override
    public Tecnologia buscar(int id) {
        return tecnologiaRepository.buscar(id);
    }
}
