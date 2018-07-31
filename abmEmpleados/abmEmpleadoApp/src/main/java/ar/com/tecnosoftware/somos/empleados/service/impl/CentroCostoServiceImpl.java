package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CentroCosto;
import ar.com.tecnosoftware.somos.empleados.repository.CentroCostoRepository;
import ar.com.tecnosoftware.somos.empleados.service.CentroCostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CentroCostoServiceImpl implements CentroCostoService {

    @Autowired
    private CentroCostoRepository centroCostoRepository;

    @Override
    public void addCentroCosto(CentroCosto centroCosto) {
        centroCostoRepository.guardar(centroCosto);
    }
}
