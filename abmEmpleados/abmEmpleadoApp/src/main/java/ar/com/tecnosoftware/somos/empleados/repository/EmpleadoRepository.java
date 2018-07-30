package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository {

    public void guardar(Empleado empleado);

}
