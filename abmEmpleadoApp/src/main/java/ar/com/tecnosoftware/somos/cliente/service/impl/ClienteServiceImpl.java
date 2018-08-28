package ar.com.tecnosoftware.somos.cliente.service.impl;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.cliente.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.rubro.repository.RubroRepository;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public void add(Cliente cliente) {
        cliente.setRubro(rubroRepository.buscar(cliente.getRubro().getId()));
        clienteRepository.guardar(cliente);
    }

    @Override
    public Cliente buscar(int id) {
        return clienteRepository.buscar(id);
    }

    @Override
    public List<Cliente> buscarNoBajas() {
        return clienteRepository.buscar("WHERE baja = false");
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.buscar("");
    }

    @Override
    public Cliente darBaja(int id) {
        Cliente cliente = clienteRepository.buscar(id);
        if(cliente == null){
            return null;
        }
        return clienteRepository.darBaja(cliente);
    }

    @Override
    public List<Cliente> buscarClientesConRubro(int idRubro) {
        return clienteRepository.buscar("WHERE rubro = " +idRubro);
    }

    @Override
    public Boolean darBajaRubroDeClientes(List<Cliente> clientes) {
        Rubro rubro = rubroRepository.buscar(1);
        for(Cliente cliente : clientes){
            if(clienteRepository.darBajaRubroDeCliente(cliente, rubro) == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public Cliente editar(Cliente cliente) {
        if (clienteRepository.buscar(cliente.getId()) == null){
            return null;
        }
        return clienteRepository.editar(cliente);
    }
}
