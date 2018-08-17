package ar.com.tecnosoftware.somos.service;

import ar.com.tecnosoftware.somos.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public void addCliente(Cliente cliente);

    public List<Cliente> buscarTodos();

    public void darBaja(int id);

}
