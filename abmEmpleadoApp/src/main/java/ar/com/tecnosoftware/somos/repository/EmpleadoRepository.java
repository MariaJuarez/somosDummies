package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.entity.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository {

    public void guardar(Empleado empleado);

    public List<Empleado> buscarTodos();

    public Empleado buscar(Empleado empleado);

    public void darBaja(Empleado empleado);

}
