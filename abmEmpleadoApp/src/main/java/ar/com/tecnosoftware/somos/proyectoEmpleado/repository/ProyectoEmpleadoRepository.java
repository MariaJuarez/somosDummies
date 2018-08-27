package ar.com.tecnosoftware.somos.proyectoEmpleado.repository;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.repository.Repository;

import java.util.List;

public interface ProyectoEmpleadoRepository extends Repository<ProyectoEmpleado> {

    void darBajaCargoDeProyectoEmpleado(ProyectoEmpleado proyectoEmpleado, Cargo cargo);

    List<Empleado> buscarEmpleadosPorFiltro(String hql, FiltroEmpleado filtroEmpleado, int tipoFiltro);
}
