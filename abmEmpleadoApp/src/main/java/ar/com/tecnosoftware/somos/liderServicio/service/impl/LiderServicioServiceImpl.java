package ar.com.tecnosoftware.somos.liderServicio.service.impl;

import ar.com.tecnosoftware.somos.liderServicio.entity.LiderServicio;
import ar.com.tecnosoftware.somos.liderServicio.repository.LiderServicioRepository;
import ar.com.tecnosoftware.somos.liderServicio.service.LiderServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiderServicioServiceImpl implements LiderServicioService {

    @Autowired
    private LiderServicioRepository liderServicioRepository;

    @Override
    public String add(LiderServicio liderServicio) {
        liderServicioRepository.guardar(liderServicio);
        return "";
    }

    @Override
    public List<LiderServicio> buscarTodos() {
        return liderServicioRepository.buscar("");
    }

    @Override
    public LiderServicio darBaja(int id) {
        LiderServicio liderServicio = liderServicioRepository.buscar(id);
        if (liderServicio == null) {
            return null;
        }
        return liderServicioRepository.darBaja(liderServicio);
    }

    @Override
    public LiderServicio buscar(int id) {
        return liderServicioRepository.buscar(id);
    }

    @Override
    public List<LiderServicio> buscarNoBajas() {
        return liderServicioRepository.buscar("WHERE baja = false");
    }

    @Override
    public LiderServicio editar(LiderServicio liderServicio) {
        if (liderServicioRepository.buscar(liderServicio.getIdLds()) == null) {
            return null;
        }
        return liderServicioRepository.editar(liderServicio);
    }
}
