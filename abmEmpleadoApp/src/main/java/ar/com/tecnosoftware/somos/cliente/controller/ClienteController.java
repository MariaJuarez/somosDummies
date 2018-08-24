package ar.com.tecnosoftware.somos.cliente.controller;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    @GetMapping (value = "/listarActivos")
    public List<Cliente> findClienteActivos(){ return clienteService.buscarNoBajas();}

    @GetMapping (value = "/listarTodos")
    public List<Cliente> findAllCliente(){ return clienteService.buscarTodos();}

    @PutMapping (value = "/baja/{id}")
    public void bajaCliente(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaProyectos(proyectos);
        clienteService.darBaja(id);
    }

}
