package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;
import ar.com.tecnosoftware.somos.empleados.repository.CargoRHPRORepository;
import ar.com.tecnosoftware.somos.empleados.service.CargoRHPROService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoRHPROServiceImpl implements CargoRHPROService {

    @Autowired
    private CargoRHPRORepository cargoRHPRORepository;

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