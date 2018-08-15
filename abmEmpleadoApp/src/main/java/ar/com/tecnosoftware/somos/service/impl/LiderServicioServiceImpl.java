package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.LiderServicio;
import ar.com.tecnosoftware.somos.repository.LiderRepository;
import ar.com.tecnosoftware.somos.service.LiderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LiderServiceImpl implements LiderService {

    @Autowired
    private LiderRepository liderRepository;

    @Override
    public void add(Object entity) {
        liderRepository.guardar((LiderServicio) entity);
    }

    @Override
    public List<LiderServicio> buscarTodos() {
        return liderRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        LiderServicio liderServicio = (LiderServicio) liderRepository.buscar(id);
        liderRepository.darBaja(liderServicio);
    }

    @Override
    public Object buscar(int id) {
        return liderRepository.buscar(id);
    }
}
