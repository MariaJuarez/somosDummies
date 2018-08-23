package ar.com.tecnosoftware.somos.empleado.repository;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.repository.Repository;

import java.util.List;

public interface EmpleadoRepository extends Repository<Empleado> {

    void darBajaAreaDeEmpleado(Empleado empleado, Area area);

    void darBajaPerfilDeEmpleado(Empleado empleado, Perfil perfil);

    List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeEmpleado(Empleado empleado);

    List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado);
}
