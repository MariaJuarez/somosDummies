package ar.com.tecnosoftware.somos.empleado.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.exception.EmpleadoErrorException;
import ar.com.tecnosoftware.somos.empleado.exception.EmpleadoNotFoundException;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyectoEmpleado.entity.ProyectoEmpleado;
import ar.com.tecnosoftware.somos.proyectoEmpleado.service.ProyectoEmpleadoService;
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
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    @PostMapping(value = "/crear")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.add(empleado);
    }

    @GetMapping (value = "/listarActivos")
    public ResponseEntity<List<Empleado>> findEmpleadoActivos() throws EmpleadoErrorException{
        List<Empleado> empleados = empleadoService.buscarNoBajas();
        if(empleados == null){
            throw new EmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping (value = "/listarTodos")
    public ResponseEntity<List<Empleado>> findAllEmpleado() throws EmpleadoErrorException {
        List<Empleado> empleados = empleadoService.buscarTodos();
        if(empleados == null){
            throw new EmpleadoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(empleados);
    }

    @PutMapping (value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Empleado> bajaEmpleado(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) throws EmpleadoErrorException, EmpleadoNotFoundException{
        Empleado empleado = empleadoService.darBaja(id);
        if(empleado == null){
            throw new EmpleadoNotFoundException("No se encontró el empleado con id " + id);
        }

        if (!proyectoEmpleadoService.darBajaProyectosEmpleados(proyectoEmpleados)){
            throw new EmpleadoErrorException("Hubo un error al dar de baja al empleado por la relación con los ProyectoEmpleados");
        }

        return ResponseEntity.ok(empleado);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Empleado> editarEmpleado(@RequestBody Empleado empleado) throws EmpleadoNotFoundException{

        Empleado empleadoEditado = empleadoService.editar(empleado);

        if(empleadoEditado == null){
            throw new EmpleadoNotFoundException("No se encontró el empleado con id " + empleado.getId());
        }

        return ResponseEntity.ok(empleadoEditado);
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(EmpleadoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(EmpleadoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(EmpleadoErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }
}
