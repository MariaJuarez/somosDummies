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
    public String add(TipoTecnologia tipoTecnologia) {
        tipoTecnologiaRepository.guardar(tipoTecnologia);
        return "";
    }

    @Override
    public List<TipoTecnologia> buscarTodos() {
        return tipoTecnologiaRepository.buscar("");
    }

    @Override
    public TipoTecnologia darBaja(int id) {
        TipoTecnologia tipoTecnologia = tipoTecnologiaRepository.buscar(id);
        if (tipoTecnologia == null) {
            return null;
        }
        return tipoTecnologiaRepository.darBaja(tipoTecnologia);
    }

    @Override
    public TipoTecnologia buscar(int id) {
        return tipoTecnologiaRepository.buscar(id);
    }

    @Override
    public List<TipoTecnologia> buscarNoBajas() {
        return tipoTecnologiaRepository.buscar("WHERE baja = false");
    }

    @Override
    public TipoTecnologia editar(TipoTecnologia tipoTecnologia) {
        if (tipoTecnologiaRepository.buscar(tipoTecnologia.getId()) == null) {
            return null;
        }

        return tipoTecnologiaRepository.editar(tipoTecnologia);
    }
}
