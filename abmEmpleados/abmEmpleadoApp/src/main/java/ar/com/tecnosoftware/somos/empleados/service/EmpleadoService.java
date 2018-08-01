package ar.com.tecnosoftware.somos.empleados.service;

import ar.com.tecnosoftware.somos.empleados.entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    public void addEmpleado(Empleado empleado);

    public List<Empleado> buscarTodos();

    public void darBaja(Empleado empleado);
}
