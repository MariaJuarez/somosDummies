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
    public String add(Tecnologia tecnologia) {
        TipoTecnologia tipoTecnologia = tipoTecnologiaRepository.buscar(tecnologia.getTipo().getId());
        if (tipoTecnologia == null) {
            return "No existe el Tipo Tecnologia con id " + tecnologia.getTipo().getId();
        }
        tecnologia.setTipo(tipoTecnologia);
        tecnologiaRepository.guardar(tecnologia);
        return "Tecnologia creada con exito";
    }

    @Override
    public List<Tecnologia> buscarTodos() {
        return tecnologiaRepository.buscar("");
    }

    @Override
    public Tecnologia darBaja(int id) {
        Tecnologia tecnologia = tecnologiaRepository.buscar(id);
        if (tecnologia == null) {
            return null;
        }
        return tecnologiaRepository.darBaja(tecnologia);
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
    public Boolean darBajaTipoTecnologiasDeTecnologias(List<Tecnologia> tecnologias) {
        TipoTecnologia tipoTecnologia = tipoTecnologiaRepository.buscar(1);
        if (tipoTecnologia == null) {
            return false;
        }
        for (Tecnologia tecnologia : tecnologias) {
            if (tecnologiaRepository.darBajaTipoTecnologiaDeTecnologia(tecnologia, tipoTecnologia) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Tecnologia editar(Tecnologia tecnologia) {
        if (tecnologiaRepository.buscar(tecnologia.getId()) == null) {
            return null;
        }
        return tecnologiaRepository.editar(tecnologia);
    }
}
