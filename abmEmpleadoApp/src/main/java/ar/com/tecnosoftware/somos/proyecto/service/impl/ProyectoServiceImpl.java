package ar.com.tecnosoftware.somos.proyecto.service.impl;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.cliente.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.metodologia.repository.MetodologiaRepository;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.filtro.FiltroProyecto;
import ar.com.tecnosoftware.somos.proyecto.repository.ProyectoRepository;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.repository.TecnologiaRepository;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.tipoProyecto.repository.TipoProyectoRepository;
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
    public String add(Proyecto proyecto) {
        String resultado = "No existe ";
        TipoProyecto tipoProyecto = tipoProyectoRepository.buscar(proyecto.getTipo().getId());
        if (tipoProyecto == null) {
            resultado += " el Tipo de Proyecto con id " + proyecto.getTipo().getId();
            return resultado;
        }
        proyecto.setTipo(tipoProyecto);

        Cliente cliente = clienteRepository.buscar(proyecto.getCliente().getId());
        if (cliente == null) {
            resultado += "el Cliente con id " + proyecto.getCliente().getId();
            return resultado;
        }
        proyecto.setCliente(cliente);

        Metodologia metodologia = metodologiaRepository.buscar(proyecto.getMetodologia().getId());
        if (metodologia == null) {
            resultado += "la Metodologia con id " + proyecto.getMetodologia().getId();
            return resultado;
        }
        proyecto.setMetodologia(metodologia);

        if (proyecto.getTecnologias().size() == 0) {
            resultado += "Debe introducir al menos una tecnología.";
            return resultado;
        }
        proyecto.setTecnologias(setTecnologias(proyecto.getTecnologias()));

        proyectoRepository.guardar(proyecto);
        return "";
    }

    @Override
    public List<Proyecto> buscarTodos() {
        return proyectoRepository.buscar("");
    }

    @Override
    public Proyecto darBaja(int id) {
        Proyecto proyecto = proyectoRepository.buscar(id);
        if (proyecto == null) {
            return null;
        }
        return proyectoRepository.darBaja(proyecto);
    }

    @Override
    public Proyecto buscar(int id) {
        return proyectoRepository.buscar(id);
    }

    @Override
    public List<Proyecto> buscarNoBajas() {
        return proyectoRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Tecnologia> setTecnologias(List<Tecnologia> tecnologias) {
        List<Tecnologia> tecnologiasEnBD = new ArrayList<>();

        for (Tecnologia tecnologia : tecnologias) {
            Tecnologia temp = tecnologiaRepository.buscar(tecnologia.getId());
            if (temp != null) {
                tecnologiasEnBD.add(temp);
            }
        }

        return tecnologiasEnBD;
    }

    @Override
    public List<Proyecto> buscarProyectosConCliente(int idCliente) {
        return proyectoRepository.buscar("WHERE clientes = " + idCliente);
    }

    @Override
    public Boolean darBajaProyectos(List<Proyecto> proyectos) {
        for (Proyecto proyecto : proyectos) {
            if (proyectoRepository.darBaja(proyecto) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Proyecto> buscarProyectosConMetodologia(int idMetodologia) {
        return proyectoRepository.buscar("WHERE metodologia = " + idMetodologia);
    }

    @Override
    public Boolean darBajaMetodologiaDeProyectos(List<Proyecto> proyectos) {
        Metodologia metodologia = metodologiaRepository.buscar(1);
        if (metodologia == null) {
            return false;
        }
        for (Proyecto proyecto : proyectos) {
            if (proyectoRepository.darBajaMetodologiaDeProyecto(proyecto, metodologia) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Proyecto> buscarProyectosConTipoProyecto(int idTipoProyecto) {
        return proyectoRepository.buscar("WHERE tipo = " + idTipoProyecto);
    }

    @Override
    public Boolean darBajaTipoProyectoDeProyectos(List<Proyecto> proyectos) {
        TipoProyecto tipoProyecto = tipoProyectoRepository.buscar(1);
        if (tipoProyecto == null) {
            return false;
        }
        for (Proyecto proyecto : proyectos) {
            if (proyectoRepository.darBajaTipoProyectoDeProyecto(proyecto, tipoProyecto) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Proyecto> buscarProyectosConTecnologia(int idTecnologia) {
        return proyectoRepository.buscarProyectosConTecnologia(idTecnologia);
    }

    @Override
    public Boolean darBajaTecnologiaDeProyectos(List<Proyecto> proyectos, Tecnologia tecnologia) {

        for (Proyecto proyecto : proyectos) {
            proyecto.getTecnologias().remove(tecnologia);
            if (proyectoRepository.darBajaTecnologiaDeProyecto(proyecto) == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Proyecto> buscarPorFiltro(FiltroProyecto filtroProyecto) {
        return proyectoRepository.buscarPorFiltro(filtroProyecto);
    }

    @Override
    public Proyecto editar(Proyecto proyecto) {
        if (proyectoRepository.buscar(proyecto.getId()) == null) {
            return null;
        }
        return proyectoRepository.editar(proyecto);
    }
}
