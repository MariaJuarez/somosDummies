package ar.com.tecnosoftware.somos.empleado.service.impl;


import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.area.repository.AreaRepository;
import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.filtro.FiltroEmpleado;
import ar.com.tecnosoftware.somos.empleado.repository.EmpleadoRepository;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.repository.PerfilRepository;
import ar.com.tecnosoftware.somos.senority.Senority;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.tecnologia.repository.TecnologiaRepository;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.repository.TipoTecnologiaRepository;
import ar.com.tecnosoftware.somos.tipoTecnologia.repository.impl.TipoTecnologiaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        /*Para la carga previa*/
        /*TipoTecno*/
        /*
        TipoTecnologia tipotec= new TipoTecnologia();
        tipotec.setDescripcion("java");
        tipotec.setBaja(false);

        //tipoTecnologiaRepository.guardar(tipotec);

        /*Perfil*/
        /*
        Perfil per=new Perfil();
        per.setAbreviatura("abreviatura");
        per.setDescripcion("desc");
        per.setBaja(false);
        per.setId(1);
        //perfilRepository.guardar(per);

        /*Area*/
        /*
        Area area=new Area();
        per.setDescripcion("desc");
        per.setBaja(false);
        area.setId(1);
        //areaRepository.guardar(area);

        /*Tecnologia*/
        /*
        Tecnologia tec=new Tecnologia();
        tec.setDescripcion("desc");
        tec.setBaja(false);

        tipotec.setId(1);
        tec.setTipo(tipotec);
        tec.setSenority(Senority.JUNIOR);
        tec.setId(1);
        //tecnologiaRepository.guardar(tec);



        /*Empleado*/
        /*
        Empleado emp=new Empleado();
        emp.setLegajo(1);
        emp.setNombres("nombres");
        emp.setApellidos("apellidos");
        emp.setCuil("cuil");
        emp.setResponsable("responsable");
        emp.setIngreso(null);
        emp.setEgreso(null);
        emp.setDomicilio("domicilio");
        emp.setObservaciones("observaciones");
        emp.setPromovido(false);
        emp.setEmail("email");
        emp.setTelefono("telefono");
        emp.setBaja(false);
        emp.setPerfil(per);
        emp.setArea(area);
        emp.setSenority(Senority.JUNIOR);
        ArrayList<Tecnologia> tecs= new ArrayList<>();
        tecs.add(tec);
        emp.setTecnologias(tecs);


        empleadoRepository.guardar(emp);
        */

    }

    @Override
    public void add(Empleado empleado) {
        empleado.setArea(areaRepository.buscar(empleado.getArea().getId()));
        empleado.setTecnologias(setTecnologias(empleado.getTecnologias()));
        empleadoRepository.guardar(empleado);
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
    public void darBaja(int id) {
        empleadoRepository.darBaja(empleadoRepository.buscar(id));
    }

    @Override
    public List<Empleado> buscarEmpleadosConArea(int idArea) {
        return empleadoRepository.buscar("WHERE area = " + idArea);
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

    @Override
    public List<Empleado> buscarPorFiltro(FiltroEmpleado filtroEmpleado) {
        return empleadoRepository.buscarPorFiltro(filtroEmpleado);
    }
}


