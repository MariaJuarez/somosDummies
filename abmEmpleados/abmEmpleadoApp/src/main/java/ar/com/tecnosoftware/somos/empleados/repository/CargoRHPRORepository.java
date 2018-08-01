package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;

public interface CargoRHPRORepository {

    public void guardar(CargoRHPRO cargoRHPRO);

    public CargoRHPRO buscar(CargoRHPRO cargoRHPRO);

}
