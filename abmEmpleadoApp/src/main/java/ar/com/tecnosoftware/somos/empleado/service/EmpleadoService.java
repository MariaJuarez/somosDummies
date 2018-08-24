package ar.com.tecnosoftware.somos.empleado.service;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.service.Service;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;

import java.util.List;

public interface EmpleadoService extends Service<Empleado> {

    List<Empleado> buscarEmpleadosConArea(int idArea);

    void darBajaAreaDeEmpleados(List<Empleado> empleados);

    List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

    List<Empleado> buscarEmpleadosConPerfil(int idPerfil);

    void darBajaPerfilDeEmpleados(List<Empleado> empleados);

    List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeEmpleados(List<Empleado> empleados, int idTecnologia);

    List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado);

}
