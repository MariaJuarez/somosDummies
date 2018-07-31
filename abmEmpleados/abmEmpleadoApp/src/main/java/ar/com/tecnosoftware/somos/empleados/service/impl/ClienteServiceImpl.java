package ar.com.tecnosoftware.somos.empleados.service.impl;

import ar.com.tecnosoftware.somos.empleados.entity.Cliente;
import ar.com.tecnosoftware.somos.empleados.repository.ClienteRepository;
import ar.com.tecnosoftware.somos.empleados.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepository.guardar(cliente);
    }
}
