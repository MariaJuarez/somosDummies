package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.*;
import ar.com.tecnosoftware.somos.repository.*;
import ar.com.tecnosoftware.somos.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TipoProyectoRepository tipoProyectoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    @Autowired
    private MetodologiaRepository metodologiaRepository;

    @Override
    public void add(Proyecto proyecto) {
        proyecto.setTipoProyecto(tipoProyectoRepository.buscar(proyecto.getTipoProyecto().getIdTipoProyecto()));
        proyecto.setCliente(clienteRepository.buscar(proyecto.getCliente().getIdCliente()));
        proyecto.setMetodologia(metodologiaRepository.buscar(proyecto.getMetodologia().getIdMetodologia()));
        proyecto.setTecnologias(setTecnologias(proyecto.getTecnologias()));
        proyectoRepository.guardar(proyecto);
    }

    @Override
    public List<Proyecto> buscarTodos() {
        return proyectoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        proyectoRepository.darBaja(proyectoRepository.buscar(id));
    }

    @Override
    public Proyecto buscar(int id) {
        return proyectoRepository.buscar(id);
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
    public List<Proyecto> buscarProyectosConCliente(int idCliente) {
        return proyectoRepository.buscarProyectosConCliente(idCliente);
    }

    @Override
    public void darBajaProyectos(List<Proyecto> proyectos) {
        for (Proyecto proyecto : proyectos) {
            proyectoRepository.darBaja(proyecto);
        }
    }

    @Override
    public List<Proyecto> buscarProyectosConMetodologia(int idMetodologia) {
        return proyectoRepository.buscarProyectosConMetodologia(idMetodologia);
    }

    @Override
    public void darBajaMetodologiaDeProyectos(List<Proyecto> proyectos) {
        Metodologia metodologia = metodologiaRepository.buscar(1);
        for(Proyecto proyecto : proyectos){
            proyectoRepository.darBajaMetodologiaDeProyecto(proyecto, metodologia);
        }
    }

    @Override
    public List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto) {
        return proyectoRepository.buscarProyectosConTipoProyecto(idTipoProyecto);
    }

    @Override
    public void darBajaTipoProyectoDeProyectos(List<Proyecto> proyectos) {
        TipoProyecto tipoProyecto = tipoProyectoRepository.buscar(1);
        for(Proyecto proyecto : proyectos){
            proyectoRepository.darBajaTipoProyectoDeProyecto(proyecto, tipoProyecto);
        }
    }

    @Override
    public List<Proyecto> buscarProyectosConTecnologia(int idTecnologia) {
        return proyectoRepository.buscarProyectosConTecnologia(idTecnologia);
    }

    @Override
    public void darBajaTecnologiaDeProyectos(List<Proyecto> proyectos, int idTecnologia) {
        Tecnologia tecnologia = tecnologiaRepository.buscar(idTecnologia);
        for (Proyecto proyecto : proyectos){
            proyecto.getTecnologias().remove(tecnologia);
            proyectoRepository.darBajaTecnologiaDeProyecto(proyecto);
        }
    }
}
