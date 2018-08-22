package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;

import java.util.List;

public interface ProyectoService extends Service<Proyecto> {

    List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

    List<Proyecto> buscarProyectosConCliente(int idCliente);

    List<Proyecto> buscarProyectosConMetodologia(int idMetodologia);

    void darBajaMetodologiaDeProyectos(List<Proyecto> proyectos);

    List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto);

    void darBajaTipoProyectoDeProyectos(List<Proyecto> proyectos);

    void darBajaProyectos(List<Proyecto> proyectos);

    List<Proyecto> buscarProyectosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeProyectos(List<Proyecto> proyectos, int idTecnologia);

}
