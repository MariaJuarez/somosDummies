package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;
import ar.com.tecnosoftware.somos.empleados.repository.CargoRHPRORepository;
import ar.com.tecnosoftware.somos.empleados.service.CargoRHPROService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CargoRHPROServiceImpl implements CargoRHPROService {

    @Autowired
    private CargoRHPRORepository cargoRHPRORepository;

    /**
     * Metodo para añadir cargo a la DB
     *
     */
    @Override
    public void addCargoRHPRO(CargoRHPRO cargoRHPRO) {
        cargoRHPRORepository.guardar(cargoRHPRO);
    }
}
