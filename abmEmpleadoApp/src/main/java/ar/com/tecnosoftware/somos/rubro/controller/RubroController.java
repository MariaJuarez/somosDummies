package ar.com.tecnosoftware.somos.rubro.controller;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.rubro.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rubro")
public class RubroController {

    @Autowired
    private RubroService rubroService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/crear")
    public void addRubro(@Valid @RequestBody Rubro rubro) {
        rubroService.add(rubro);
    }

    @GetMapping (value = "/listar")
    public List<Rubro> findAllRubro(){
        return rubroService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaRubro(@PathVariable int id, @RequestBody List<Cliente> clientes) {
        clienteService.darBajaRubroDeClientes(clientes);
        rubroService.darBaja(id);
    }

}
