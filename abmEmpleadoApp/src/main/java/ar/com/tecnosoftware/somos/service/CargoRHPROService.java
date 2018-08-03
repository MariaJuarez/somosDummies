package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entityoOld.CargoRHPRO;

import java.util.List;

public interface CargoRHPROService {

    public void addCargoRHPRO(CargoRHPRO cargoRHPRO);

    public List<CargoRHPRO> buscarTodos();

    public void darBaja(CargoRHPRO cargoRHPRO);

}
