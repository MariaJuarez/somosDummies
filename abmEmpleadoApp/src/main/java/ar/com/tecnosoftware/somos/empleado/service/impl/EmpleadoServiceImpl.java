package ar.com.tecnosoftware.somos.empleado.service.impl;


import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.area.repository.AreaRepository;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.empleado.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.repository.PerfilRepository;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.tecnologia.repository.TecnologiaRepository;
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
    public String add(Empleado empleado) {

        Area area = areaRepository.buscar(empleado.getArea().getId());
        if(area == null){
            return "No existe el Area con id " + empleado.getArea().getId();
        }
        empleado.setArea(area);
        empleado.setTecnologias(setTecnologias(empleado.getTecnologias()));
        empleadoRepository.guardar(empleado);
        return "Empleado creado con exito";
    }

    @Override
    public Empleado buscar(int id) {
        return empleadoRepository.buscar(id);
    }

    @Override
    public List<Empleado> buscarNoBajas() {
        return empleadoRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empleadoRepository.buscar("");
    }

    @Override
    public Empleado darBaja(int id) {
        Empleado empleado = empleadoRepository.buscar(id);
        if(empleado == null){
            return null;
        }
        return empleadoRepository.darBaja(empleado);
    }

    @Override
    public List<Empleado> buscarEmpleadosConArea(int idArea) {
        return empleadoRepository.buscar("WHERE area = " + idArea);
    }

    @Override
    public Boolean darBajaAreaDeEmpleados(List<Empleado> empleados) {
        Area area = areaRepository.buscar(1);
        if(area == null){
            return false;
        }

        for(Empleado empleado : empleados){
            if (empleadoRepository.darBajaAreaDeEmpleado(empleado, area) == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias) {
        List<Tecnologia> tecnologiasEnBD = new ArrayList<>();

        for (Tecnologia tecnologia : tecnologias){
            Tecnologia temp = tecnologiaRepository.buscar(tecnologia.getId());
            if(temp != null){
                tecnologiasEnBD.add(temp);
            }
        }

        return tecnologiasEnBD;
    }

    @Override
    public List<Empleado> buscarEmpleadosConPerfil(int idPerfil) {
        return empleadoRepository.buscar("WHERE perfil = " +idPerfil);
    }

    @Override
    public Boolean darBajaPerfilDeEmpleados(List<Empleado> empleados) {
        Perfil perfil = perfilRepository.buscar(1);
        if(perfil == null){
            return false;
        }

        for(Empleado empleado : empleados){
            if(empleadoRepository.darBajaPerfilDeEmpleado(empleado, perfil) == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Empleado> buscarEmpleadosConTecnologia(int idTecnologia) {
        return empleadoRepository.buscarEmpleadosConTecnologia(idTecnologia);
    }

    @Override
    public Boolean darBajaTecnologiaDeEmpleados(List<Empleado> empleados, Tecnologia tecnologia) {

        for (Empleado empleado : empleados){
            empleado.getTecnologias().remove(tecnologia);
            if(empleadoRepository.darBajaTecnologiaDeEmpleado(empleado) == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado) {
        return empleadoRepository.buscarPorFiltro(filtroEmpleado);
    }

    @Override
    public Empleado editar(Empleado empleado) {
        if (empleadoRepository.buscar(empleado.getId()) == null){
            return null;
        }
        return empleadoRepository.editar(empleado);
    }
}


