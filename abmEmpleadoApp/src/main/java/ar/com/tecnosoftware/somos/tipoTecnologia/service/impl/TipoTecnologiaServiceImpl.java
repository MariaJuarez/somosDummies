package ar.com.tecnosoftware.somos.tipoTecnologia.service.impl;

import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.repository.TipoTecnologiaRepository;
import ar.com.tecnosoftware.somos.tipoTecnologia.service.TipoTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoTecnologiaServiceImpl implements TipoTecnologiaService {

    @Autowired
    private TipoTecnologiaRepository tipoTecnologiaRepository;

    @Override
    public void add(TipoTecnologia tipoTecnologia) {
        tipoTecnologiaRepository.guardar(tipoTecnologia);
    }

    @Override
    public List<TipoTecnologia> buscarTodos() {
        return tipoTecnologiaRepository.buscar("");
    }

    @Override
    public void darBaja(int id) {
        tipoTecnologiaRepository.darBaja(tipoTecnologiaRepository.buscar(id));
    }

    @Override
    public TipoTecnologia buscar(int id) {
        return tipoTecnologiaRepository.buscar(id);
    }

    @Override
    public List<TipoTecnologia> buscarNoBajas() {
        return tipoTecnologiaRepository.buscar("WHERE baja = false");
    }
}
