package ar.com.tecnosoftware.somos.tecnologia.service;

import ar.com.tecnosoftware.somos.service.Service;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;

import java.util.List;

public interface TecnologiaService extends Service<Tecnologia> {

    List<Tecnologia> buscarTecnologiasConTipoTecnologia(int idTipoTecnologia);

    Boolean darBajaTipoTecnologiasDeTecnologias(List<Tecnologia> tecnologias);

}
