package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Proyecto;
import ar.com.tecnosoftware.somos.entity.Tecnologia;

import java.util.List;

public interface ProyectoService extends Service<Proyecto> {

    public List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

}
