package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entityoOld.CargoRHPRO;
import ar.com.tecnosoftware.somos.repository.CargoRHPRORepository;
import ar.com.tecnosoftware.somos.service.CargoRHPROService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<CargoRHPRO> buscarTodos() {
        return cargoRHPRORepository.buscarTodos();
    }

    @Override
    public void darBaja(CargoRHPRO cargoRHPRO) {
        cargoRHPRORepository.darBaja(cargoRHPRORepository.buscar(cargoRHPRO));
    }
}
