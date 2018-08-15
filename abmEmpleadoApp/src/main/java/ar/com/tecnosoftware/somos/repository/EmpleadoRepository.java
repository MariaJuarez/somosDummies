package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.entity.Empleado;

import java.util.List;

public interface EmpleadoRepository extends Repository <Empleado> {

    public List<Empleado> buscarEmpleadosConArea(int idArea);

    public void darBajaAreaDeEmpleado(Empleado empleado, Area area);
}
