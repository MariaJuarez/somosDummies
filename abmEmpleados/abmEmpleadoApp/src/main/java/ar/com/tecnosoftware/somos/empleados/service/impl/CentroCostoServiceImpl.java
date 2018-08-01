package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CentroCosto;
import ar.com.tecnosoftware.somos.empleados.repository.CentroCostoRepository;
import ar.com.tecnosoftware.somos.empleados.service.CentroCostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CentroCostoServiceImpl implements CentroCostoService {

    @Autowired
    private CentroCostoRepository centroCostoRepository;

    @Override
    public void addCentroCosto(CentroCosto centroCosto) {
        centroCostoRepository.guardar(centroCosto);
    }

    @Override
    public List<CentroCosto> buscarTodos() {
        return centroCostoRepository.buscarTodos();
    }

    @Override
    public void darBaja(CentroCosto centroCosto) {
        centroCostoRepository.darBaja(centroCostoRepository.buscar(centroCosto));
    }
}
