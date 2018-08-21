package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Tecnologia;

import java.util.List;

public interface TecnologiaService extends Service<Tecnologia> {

    List<Tecnologia> buscarTecnologiasConTipoTecnologia(int idTipoTecnologia);

    void darBajaTipoTecnologiasDeTecnologias(List<Tecnologia> tecnologias);

}
