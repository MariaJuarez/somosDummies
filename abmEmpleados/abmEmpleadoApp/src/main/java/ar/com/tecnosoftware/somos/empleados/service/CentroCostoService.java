package ar.com.tecnosoftware.somos.empleados.service;

import ar.com.tecnosoftware.somos.empleados.entity.CentroCosto;

import java.util.List;

public interface CentroCostoService {

    public void addCentroCosto(CentroCosto centroCosto);

    public List<CentroCosto> buscarTodos();

    public void darBaja(CentroCosto centroCosto);

}
