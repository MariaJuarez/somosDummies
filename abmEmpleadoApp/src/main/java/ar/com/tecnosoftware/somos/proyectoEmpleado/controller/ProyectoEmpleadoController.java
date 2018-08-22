package ar.com.tecnosoftware.somos.proyectoEmpleado.controller;

import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/proyectoEmpleado")
public class ProyectoEmpleadoController {

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addProyectoEmpleado(@Valid @RequestBody ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleadoService.add(proyectoEmpleado);
    }

    @GetMapping (value = "/listar")
    public List<ProyectoEmpleado> findAllProyectoEmpleado(){
        return proyectoEmpleadoService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaProyectoEmpleado(@PathVariable int id) {
        proyectoEmpleadoService.darBaja(id);
    }

}
