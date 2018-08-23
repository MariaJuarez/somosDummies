package ar.com.tecnosoftware.somos.tecnologia.service.impl;

import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tecnologia.repository.TecnologiaRepository;
import ar.com.tecnosoftware.somos.tipoTecnologia.repository.TipoTecnologiaRepository;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
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
        tecnologia.setTipo(tipoTecnologiaRepository.buscar(tecnologia.getTipo().getId()));
        tecnologiaRepository.guardar(tecnologia);
    }

    @Override
    public List<Tecnologia> buscarTodos() {
        return tecnologiaRepository.buscar("");
    }

    @Override
    public void darBaja(int id) {
        tecnologiaRepository.darBaja(tecnologiaRepository.buscar(id));
    }

    @Override
    public Tecnologia buscar(int id) {
        return tecnologiaRepository.buscar(id);
    }

    @Override
    public List<Tecnologia> buscarNoBajas() {
        return tecnologiaRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Tecnologia> buscarTecnologiasConTipoTecnologia(int idTipoTecnologia) {
        return tecnologiaRepository.buscar("WHERE tipo = " + idTipoTecnologia);
    }

    @Override
    public void darBajaTipoTecnologiasDeTecnologias(List<Tecnologia> tecnologias) {
        TipoTecnologia tipoTecnologia = tipoTecnologiaRepository.buscar(1);
        for(Tecnologia tecnologia : tecnologias){
            tecnologiaRepository.darBajaTipoTecnologiaDeTecnologia(tecnologia, tipoTecnologia);
        }
    }
}
