package ar.com.tecnosoftware.somos.repository;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;

import java.util.List;

public interface EmpleadoRepository extends Repository <Empleado> {

    List<Empleado> buscarEmpleadosConArea(int idArea);

    void darBajaAreaDeEmpleado(Empleado empleado, Area area);

    List<Empleado> buscarEmpleadosConPerfil(int idPerfil);

    void darBajaPerfilDeEmpleado(Empleado empleado, Perfil perfil);

    List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia);

    void darBajaTecnologiaDeEmpleado(Empleado empleado);
}
