package ar.com.tecnosoftware.somos.cargo.controller;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.cargo.service.CargoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addCargo(@Valid @RequestBody Cargo cargo) {
        cargoService.add(cargo);
    }

    @GetMapping (value = "/listar")
    public List<Cargo> findAllCargos(){ return cargoService.buscarTodos();}

    @PutMapping (value = "/baja/{id}")
    public void bajaCargo(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) {
        proyectoEmpleadoService.darBajaCargoDeProyectosEmpleados(proyectoEmpleados);
        cargoService.darBaja(id);
    }

}
