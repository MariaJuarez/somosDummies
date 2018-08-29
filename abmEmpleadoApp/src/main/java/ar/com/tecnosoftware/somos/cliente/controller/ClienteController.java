package ar.com.tecnosoftware.somos.cliente.controller;

import ar.com.tecnosoftware.somos.cargo.exception.CargoErrorException;
import ar.com.tecnosoftware.somos.cargo.exception.CargoNotFoundException;
import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.cliente.exception.ClienteNotFoundException;
import ar.com.tecnosoftware.somos.cliente.exception.ClienteErrorException;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addCliente(@Valid @RequestBody Cliente cliente) throws ClienteErrorException {

        String resultado = clienteService.add(cliente);
        if (!resultado.equals("")) {
            throw new ClienteErrorException(resultado);
        }
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Cliente>> findClienteActivos() throws ClienteErrorException {
        List<Cliente> clientes = clienteService.buscarNoBajas();

        if (clientes == null) {
            throw new ClienteErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }

        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Cliente>> findAllCliente() throws ClienteErrorException {
        List<Cliente> clientes = clienteService.buscarTodos();

        if (clientes == null) {
            throw new ClienteErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }

        return ResponseEntity.ok(clientes);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Cliente> bajaCliente(@PathVariable int id, @RequestBody List<Proyecto> proyectos) throws ClienteErrorException, ClienteNotFoundException {

        Cliente cliente = clienteService.darBaja(id);

        if (cliente == null) {
            throw new ClienteNotFoundException("No se encontró el cliente con id " + id);
        }

        if (!proyectoService.darBajaProyectos(proyectos)) {
            throw new ClienteErrorException("Hubo un error al dar de baja al cliente y a sus respectivos proyectos.");
        }

        return ResponseEntity.ok(cliente);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Cliente> editarCliente(@RequestBody Cliente cliente) throws ClienteNotFoundException {
        Cliente clienteEditado = clienteService.editar(cliente);
        if (clienteEditado == null) {
            throw new ClienteNotFoundException("No se encontró el cliente con el id " + cliente.getId());
        }
        return ResponseEntity.ok(cliente);
    }

    @ExceptionHandler(CargoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(CargoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(CargoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(CargoErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
