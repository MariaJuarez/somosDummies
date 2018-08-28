package ar.com.tecnosoftware.somos.cliente.repository;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.repository.Repository;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente> {

    Cliente darBajaRubroDeCliente(Cliente cliente, Rubro rubro);

}
