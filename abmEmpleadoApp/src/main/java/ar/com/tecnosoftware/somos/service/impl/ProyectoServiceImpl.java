package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.Proyecto;
import ar.com.tecnosoftware.somos.entity.Tecnologia;
import ar.com.tecnosoftware.somos.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.repository.ProyectoRepository;
import ar.com.tecnosoftware.somos.repository.TecnologiaRepository;
import ar.com.tecnosoftware.somos.repository.TipoProyectoRepository;
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

    @Override
    public void add(Proyecto proyecto) {
        proyecto.setTipoProyecto(tipoProyectoRepository.buscar(proyecto.getTipoProyecto().getIdTipoProyecto()));
        proyecto.setCliente(clienteRepository.buscar(proyecto.getCliente().getIdCliente()));
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
}
