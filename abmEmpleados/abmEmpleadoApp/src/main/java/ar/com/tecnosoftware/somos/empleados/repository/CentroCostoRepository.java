package ar.com.tecnosoftware.somos.empleados.repository;

import ar.com.tecnosoftware.somos.empleados.entity.CentroCosto;

public interface CentroCostoRepository {

    public void guardar(CentroCosto centroCosto);

    public CentroCosto buscar(CentroCosto centroCosto);

}
