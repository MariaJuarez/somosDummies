package ar.com.tecnosoftware.somos.proyectoEmpleado.service.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.cargo.repository.CargoRepository;
import ar.com.tecnosoftware.somos.empleado.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.proyectoEmpleado.repository.ProyectoEmpleadoRepository;
import ar.com.tecnosoftware.somos.proyecto.repository.ProyectoRepository;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.util.ProyectoEmpleadoFiltroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProyectoEmpleadoServiceImpl implements ProyectoEmpleadoService {

    @Autowired
    private ProyectoEmpleadoRepository proyectoEmpleadoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ProyectoEmpleadoFiltroUtil proyectoEmpleadoFiltroUtil;

    @Override
    public void add(ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleado.setEmpleado(empleadoRepository.buscar(proyectoEmpleado.getEmpleado().getId()));
        proyectoEmpleado.setProyecto(proyectoRepository.buscar(proyectoEmpleado.getProyecto().getId()));
        proyectoEmpleado.setCargo(cargoRepository.buscar(proyectoEmpleado.getCargo().getId()));
        proyectoEmpleadoRepository.guardar(proyectoEmpleado);
    }

    @Override
    public List<ProyectoEmpleado> buscarTodos() {
        return proyectoEmpleadoRepository.buscar("");
    }

    @Override
    public List<ProyectoEmpleado> buscarNoBajas() {
        return proyectoEmpleadoRepository.buscar("WHERE baja = false");
    }

    @Override
    public void darBaja(int id) {
        proyectoEmpleadoRepository.darBaja(proyectoEmpleadoRepository.buscar(id));
    }

    @Override
    public ProyectoEmpleado buscar(int id) {
        return proyectoEmpleadoRepository.buscar(id);
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConEmpleado(int idEmpleado) {
        return proyectoEmpleadoRepository.buscar("WHERE empleado = " + idEmpleado);
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto) {
        return proyectoEmpleadoRepository.buscar("WHERE proyecto = " +idProyecto);
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo) {
        return proyectoEmpleadoRepository.buscar("WHERE cargo = " + idCargo);
    }

    @Override
    public void darBajaCargoDeProyectosEmpleados(List<ProyectoEmpleado> proyectosEmpleados) {
        Cargo cargo = cargoRepository.buscar(1);
        for(ProyectoEmpleado proyectoEmpleado : proyectosEmpleados){
            proyectoEmpleadoRepository.darBajaCargoDeProyectoEmpleado(proyectoEmpleado, cargo);
        }
    }

    @Override
    public void darBajaProyectosEmpleados(List<ProyectoEmpleado> proyectoEmpleados) {
        for (ProyectoEmpleado proyectoEmpleado : proyectoEmpleados) {
            proyectoEmpleadoRepository.darBaja(proyectoEmpleado);
        }
    }

    @Override
    public List<Empleado> buscarEmpleadosPorFiltro(FiltroEmpleado filtroEmpleado) {

        int tipoFiltro = proyectoEmpleadoFiltroUtil.filtrosProyectoEmpleado(filtroEmpleado);
        String hql = proyectoEmpleadoFiltroUtil.armarQuery(tipoFiltro);

        return proyectoEmpleadoRepository.buscarEmpleadosPorFiltro(hql, filtroEmpleado, tipoFiltro);
    }

    @Override
    public void editar(ProyectoEmpleado proyectoEmpleado) {
        if (proyectoEmpleadoRepository.buscar(proyectoEmpleado.getId()) == null){
            return;
        }
        proyectoEmpleadoRepository.editar(proyectoEmpleado);
    }
}
