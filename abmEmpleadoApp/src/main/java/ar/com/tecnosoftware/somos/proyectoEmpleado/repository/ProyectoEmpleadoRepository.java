package ar.com.tecnosoftware.somos.proyectoEmpleado.repository;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.repository.Repository;

import java.util.List;

public interface ProyectoEmpleadoRepository extends Repository<ProyectoEmpleado> {

    List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado);

    //void darBajaAreaDeEmpleado(proyectoEmpleado proyectoEmpleado, area area);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto);

    //void darBajaAreaDeEmpleado(proyectoEmpleado proyectoEmpleado, area area);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo);

    void darBajaCargoDeProyectoEmpleado(ProyectoEmpleado proyectoEmpleado, Cargo cargo);
}
