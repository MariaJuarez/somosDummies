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
    public void add(LiderServicio liderServicio) {
        liderServicioRepository.guardar(liderServicio);
    }

    @Override
    public List<LiderServicio> buscarTodos() {
        return liderServicioRepository.buscar("");
    }

    @Override
    public void darBaja(int id) {
        liderServicioRepository.darBaja(liderServicioRepository.buscar(id));
    }

    @Override
    public LiderServicio buscar(int id) {
        return liderServicioRepository.buscar(id);
    }

    @Override
    public List<LiderServicio> buscarNoBajas() {
        return liderServicioRepository.buscar("WHERE baja = false");
    }
}
