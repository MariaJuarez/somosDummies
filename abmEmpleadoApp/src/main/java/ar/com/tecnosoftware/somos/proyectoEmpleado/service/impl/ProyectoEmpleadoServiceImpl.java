package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.repository.CargoRepository;
import ar.com.tecnosoftware.somos.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.repository.ProyectoEmpleadoRepository;
import ar.com.tecnosoftware.somos.repository.ProyectoRepository;
import ar.com.tecnosoftware.somos.service.ProyectoEmpleadoService;
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

    @Override
    public void add(ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleado.setEmpleado(empleadoRepository.buscar(proyectoEmpleado.getEmpleado().getId()));
        proyectoEmpleado.setProyecto(proyectoRepository.buscar(proyectoEmpleado.getProyecto().getId()));
        proyectoEmpleado.setCargo(cargoRepository.buscar(proyectoEmpleado.getCargo().getId()));
        proyectoEmpleadoRepository.guardar(proyectoEmpleado);
    }

    @Override
    public List<ProyectoEmpleado> buscarTodos() {
        return proyectoEmpleadoRepository.buscarTodos();
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
        return proyectoEmpleadoRepository.buscarProyectosEmpleadosConEmpleado(idEmpleado);
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConProyecto(int idProyecto) {
        return proyectoEmpleadoRepository.buscarProyectosEmpleadosConProyecto(idProyecto);
    }

    @Override
    public List<ProyectoEmpleado> buscarProyectosEmpleadosConCargo(int idCargo) {
        return proyectoEmpleadoRepository.buscarProyectosEmpleadosConCargo(idCargo);
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
}
