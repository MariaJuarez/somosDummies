package ar.com.tecnosoftware.somos.empleados.service;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;

import java.util.List;

public interface CargoRHPROService {

    public void addCargoRHPRO(CargoRHPRO cargoRHPRO);

    public List<CargoRHPRO> buscarTodos();

    public void darBaja(CargoRHPRO cargoRHPRO);

}
