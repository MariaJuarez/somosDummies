package ar.com.tecnosoftware.somos.service.impl;


import ar.com.tecnosoftware.somos.entity.Area;
import ar.com.tecnosoftware.somos.entity.Empleado;
import ar.com.tecnosoftware.somos.entity.Perfil;
import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.repository.*;
import ar.com.tecnosoftware.somos.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public void add(Empleado empleado) {
        empleado.setArea(areaRepository.buscar(empleado.getArea().getIdCentroCosto()));
        empleado.setTecnologias(setTecnologias(empleado.getTecnologias()));
        empleadoRepository.guardar(empleado);
    }

    @Override
    public Empleado buscar(int id) {
        return empleadoRepository.buscar(id);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        empleadoRepository.darBaja(empleadoRepository.buscar(id));
    }

    @Override
    public List<Empleado> buscarEmpleadosConArea(int idArea) {
        return empleadoRepository.buscarEmpleadosConArea(idArea);
    }

    @Override
    public void darBajaAreaDeEmpleados(List<Empleado> empleados) {
        Area area = areaRepository.buscar(1);
        for(Empleado empleado : empleados){
            empleadoRepository.darBajaAreaDeEmpleado(empleado, area);
        }
    }

    @Override
    public List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias) {
        List<Tecnologia> tecnologiasEnBD = new ArrayList<>();

        for (Tecnologia tecnologia : tecnologias){
            Tecnologia temp = tecnologiaRepository.buscar(tecnologia.getIdTecnologia());
            if(temp != null){
                tecnologiasEnBD.add(temp);
            }
        }

        return tecnologiasEnBD;
    }

    @Override
    public List<Empleado> buscarEmpleadosConPerfil(int idPerfil) {
        return empleadoRepository.buscarEmpleadosConPerfil(idPerfil);
    }

    @Override
    public void darBajaPerfilDeEmpleados(List<Empleado> empleados) {
        Perfil perfil = perfilRepository.buscar(1);
        for(Empleado empleado : empleados){
            empleadoRepository.darBajaPerfilDeEmpleado(empleado, perfil);
        }
    }

    @Override
    public List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia) {
        return empleadoRepository.buscarEmpleadosConTecnologia(idTecnologia);
    }

    @Override
    public void darBajaTecnologiaDeEmpleados(List<Empleado> empleados, int idTecnologia) {
        Tecnologia tecnologia = tecnologiaRepository.buscar(idTecnologia);
        for (Empleado empleado : empleados){
            empleado.getTecnologias().remove(tecnologia);
            empleadoRepository.darBajaTecnologiaDeEmpleado(empleado);
        }
    }
}


