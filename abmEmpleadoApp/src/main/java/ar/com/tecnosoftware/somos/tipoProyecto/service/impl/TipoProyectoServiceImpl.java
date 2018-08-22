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
    public void add(TipoProyecto tipoProyecto) {
        tipoProyectoRepository.guardar(tipoProyecto);
    }

    @Override
    public List<TipoProyecto> buscarTodos() {
        return tipoProyectoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        tipoProyectoRepository.darBaja(tipoProyectoRepository.buscar(id));
    }

    @Override
    public TipoProyecto buscar(int id) {
        return tipoProyectoRepository.buscar(id);
    }
}
