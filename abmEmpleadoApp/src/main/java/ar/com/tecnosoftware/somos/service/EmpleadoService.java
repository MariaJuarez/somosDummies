package ar.com.tecnosoftware.somos.service;


import ar.com.tecnosoftware.somos.entity.Empleado;

import java.util.List;

public interface EmpleadoService {
    public void addEmpleado(Empleado empleado);

    public List<Empleado> buscarTodos();

    public void darBaja(int id);
}
