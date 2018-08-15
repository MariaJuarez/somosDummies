package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Tecnologia;

import java.util.List;

public interface EmpleadoService extends Service<Empleado>{

    public List<Empleado> buscarEmpleadosConArea(int idArea);

    public void darBajaAreaDeEmpleados(List<Empleado> empleados);

    public List<Tecnologia>  setTecnologias(List<Tecnologia> tecnologias);

}
