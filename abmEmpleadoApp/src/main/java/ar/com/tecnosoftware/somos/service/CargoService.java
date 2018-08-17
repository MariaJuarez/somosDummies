package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Cargo;

import java.util.List;

public interface CargoService {

    public void addCargo(Cargo cargo);

    public List<Cargo> buscarTodos();

    public void darBaja(int id);

}
