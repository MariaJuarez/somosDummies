package ar.com.tecnosoftware.somos.proyectoEmpleado.service;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.service.Service;

import java.util.List;

public interface ProyectoEmpleadoService extends Service<ProyectoEmpleado> {

    List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto);

    List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo);

    Boolean darBajaCargoDeProyectosEmpleados(List<ProyectoEmpleado> proyectosEmpleados);

    Boolean darBajaProyectosEmpleados(List<ProyectoEmpleado> proyectoEmpleados);

    List<Empleado> buscarEmpleadosPorFiltro(FiltroEmpleado filtroEmpleado);

}
