package ar.com.tecnosoftware.somos.cliente.repository;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente> {

    List<Cliente> buscarClientesConRubro(int idRubro);

    void darBajaRubroDeCliente(Cliente cliente, Rubro rubro);

}
