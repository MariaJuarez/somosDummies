package ar.com.tecnosoftware.somos.tipoProyecto.service.impl;

import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.repository.TipoProyectoRepository;
import ar.com.tecnosoftware.somos.tipoProyecto.service.TipoProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoProyectoServiceImpl implements TipoProyectoService {

    @Autowired
    private TipoProyectoRepository tipoProyectoRepository;

    @Override
    public String add(TipoProyecto tipoProyecto) {
        tipoProyectoRepository.guardar(tipoProyecto);
        return "";
    }

    @Override
    public List<TipoProyecto> buscarTodos() {
        return tipoProyectoRepository.buscar("");
    }

    @Override
    public TipoProyecto darBaja(int id) {
        TipoProyecto tipoProyecto = tipoProyectoRepository.buscar(id);
        if (tipoProyecto == null) {
            return null;
        }
        return tipoProyectoRepository.darBaja(tipoProyecto);
    }

    @Override
    public TipoProyecto buscar(int id) {
        return tipoProyectoRepository.buscar(id);
    }

    @Override
    public List<TipoProyecto> buscarNoBajas() {
        return tipoProyectoRepository.buscar("WHERE baja = false");
    }

    @Override
    public TipoProyecto editar(TipoProyecto tipoProyecto) {
        if (tipoProyectoRepository.buscar(tipoProyecto.getId()) == null) {
            return null;
        }
        return tipoProyectoRepository.editar(tipoProyecto);
    }
}
