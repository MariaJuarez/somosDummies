package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.CargoRHPRO;

import java.util.List;

public interface CargoRHPRORepository {

    public void guardar(CargoRHPRO cargoRHPRO);

    public CargoRHPRO buscar(CargoRHPRO cargoRHPRO);

    public List<CargoRHPRO> buscarTodos();

    public void darBaja(CargoRHPRO cargoRHPRO);

}
