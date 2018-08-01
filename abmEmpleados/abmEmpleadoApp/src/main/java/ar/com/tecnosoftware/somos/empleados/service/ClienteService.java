package ar.com.tecnosoftware.somos.empleados.service;

import ar.com.tecnosoftware.somos.empleados.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public void addCliente(Cliente cliente);

    public List<Cliente> buscarTodos();

    public void darBaja(Cliente cliente);

}
