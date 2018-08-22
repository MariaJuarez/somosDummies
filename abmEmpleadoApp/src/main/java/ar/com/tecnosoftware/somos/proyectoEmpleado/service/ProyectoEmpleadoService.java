package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;

import java.util.List;

public interface ProyectoEmpleadoService extends Service<ProyectoEmpleado> {

    List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo);

    void darBajaCargoDeProyectosEmpleados(List<ProyectoEmpleado> proyectosEmpleados);

    void darBajaProyectosEmpleados(List<ProyectoEmpleado> proyectoEmpleados);

}
