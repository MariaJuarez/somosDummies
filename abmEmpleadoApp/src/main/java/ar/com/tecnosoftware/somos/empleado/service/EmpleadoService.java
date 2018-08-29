package ar.com.tecnosoftware.somos.empleado.service;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.service.Service;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;

import java.util.List;

public interface EmpleadoService extends Service<Empleado> {

    List<Empleado> buscarEmpleadosConArea(int idArea);

    Boolean darBajaAreaDeEmpleados(List<Empleado> empleados);

    List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

    List<Empleado> buscarEmpleadosConPerfil(int idPerfil);

    Boolean darBajaPerfilDeEmpleados(List<Empleado> empleados);

    List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia);

    Boolean darBajaTecnologiaDeEmpleados(List<Empleado> empleados, Tecnologia tecnologia);

    List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado);

}
