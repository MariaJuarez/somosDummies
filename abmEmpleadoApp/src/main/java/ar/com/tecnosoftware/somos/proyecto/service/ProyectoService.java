package ar.com.tecnosoftware.somos.proyecto.service;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.service.Service;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;

import java.util.List;

public interface ProyectoService extends Service<Proyecto> {

    List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

    List<Proyecto> buscarProyectosConCliente(int idCliente);

    List<Proyecto> buscarProyectosConMetodologia(int idMetodologia);

    Boolean darBajaMetodologiaDeProyectos(List<Proyecto> proyectos);

    List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto);

    Boolean darBajaTipoProyectoDeProyectos(List<Proyecto> proyectos);

    Boolean darBajaProyectos(List<Proyecto> proyectos);

    List<Proyecto> buscarProyectosConTecnologia(int idTecnologia);

    Boolean darBajaTecnologiaDeProyectos(List<Proyecto> proyectos, Tecnologia tecnologia);

    List<Proyecto> buscarPorFiltro(FiltroProyecto filtroProyecto);

}
