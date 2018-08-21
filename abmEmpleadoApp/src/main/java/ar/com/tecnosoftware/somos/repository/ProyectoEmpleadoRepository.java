package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Cargo;
import ar.com.tecnosoftware.somos.entity.ProyectoEmpleado;

import java.util.List;

public interface ProyectoEmpleadoRepository extends Repository<ProyectoEmpleado> {

    List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado);

    //void darBajaAreaDeEmpleado(ProyectoEmpleado proyectoEmpleado, Area area);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto);

    //void darBajaAreaDeEmpleado(ProyectoEmpleado proyectoEmpleado, Area area);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo);

    void darBajaCargoDeProyectoEmpleado(ProyectoEmpleado proyectoEmpleado, Cargo cargo);
}
