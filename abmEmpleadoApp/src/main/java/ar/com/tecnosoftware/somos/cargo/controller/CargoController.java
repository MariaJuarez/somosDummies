package ar.com.tecnosoftware.somos.cargo.controller;

import ar.com.tecnosoftware.somos.cargo.entity.Cargo;
import ar.com.tecnosoftware.somos.cargo.exception.CargoErrorException;
import ar.com.tecnosoftware.somos.cargo.exception.CargoNotFoundException;
import ar.com.tecnosoftware.somos.cargo.service.CargoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addCargo(@RequestBody Cargo cargo) {
        cargoService.add(cargo);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Cargo>> findCargosActivos() throws CargoErrorException {
        List<Cargo> cargos = cargoService.buscarNoBajas();
        if (cargos == null) {
            throw new CargoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(cargos);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Cargo>> findAllCargos() throws CargoNotFoundException {
        List<Cargo> cargos = cargoService.buscarTodos();
        if (cargos == null) {
            throw new CargoNotFoundException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(cargos);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Cargo> bajaCargo(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) throws CargoNotFoundException, CargoErrorException {
        Cargo cargo = cargoService.darBaja(id);

        if (cargo == null) {
            throw new CargoNotFoundException("No se encontró el cargo con id " + id);
        }

        if (!proyectoEmpleadoService.darBajaCargoDeProyectosEmpleados(proyectoEmpleados)) {
            throw new CargoErrorException("Hubo un error al dar de baja al cargo por la relación con los ProyectoEmpleados. Puede que no exista el Cargo por defecto.");
        }

        return ResponseEntity.ok(cargo);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Cargo> editarCargo(@RequestBody Cargo cargo) throws CargoNotFoundException {
        Cargo cargoEditado = cargoService.editar(cargo);
        if (cargoEditado == null) {
            throw new CargoNotFoundException("No se encontró el cargo con id " + cargo.getId());
        }

        return ResponseEntity.ok(cargo);

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
