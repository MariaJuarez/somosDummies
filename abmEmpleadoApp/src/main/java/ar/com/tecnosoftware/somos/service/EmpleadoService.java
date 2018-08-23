package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Tecnologia;

import java.util.List;

public interface EmpleadoService extends Service<Empleado>{

    List<Empleado> buscarEmpleadosConArea(int idArea);

    void darBajaAreaDeEmpleados(List<Empleado> empleados);

    List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias);

    List<Empleado> buscarEmpleadosConPerfil(int idPerfil);

    void darBajaPerfilDeEmpleados(List<Empleado> empleados);

    List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeEmpleados(List<Empleado> empleados, int idTecnologia);

}
