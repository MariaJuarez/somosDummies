package ar.com.tecnosoftware.somos.tecnologia.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.exception.TecnologiaErrorException;
import ar.com.tecnosoftware.somos.tecnologia.exception.TecnologiaNotFoundException;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
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
@RequestMapping("/tecnologia")
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addTecnologia(@Valid @RequestBody Tecnologia tecnologia) {
        tecnologiaService.add(tecnologia);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Tecnologia>> findTecnologiaActivos() throws TecnologiaErrorException {
        List<Tecnologia> tecnologias = tecnologiaService.buscarNoBajas();
        if (tecnologias == null) {
            throw new TecnologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tecnologias);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Tecnologia>> findAllTecnologia() throws TecnologiaErrorException {
        List<Tecnologia> tecnologias = tecnologiaService.buscarTodos();
        if (tecnologias == null) {
            throw new TecnologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tecnologias);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Tecnologia> bajaTecnologia(@PathVariable int id, @RequestBody List<Empleado> empleados, @RequestBody List<Proyecto> proyectos) throws TecnologiaNotFoundException, TecnologiaErrorException {

        Tecnologia tecnologia = tecnologiaService.darBaja(id);

        if (tecnologia == null) {
            throw new TecnologiaNotFoundException("No se encontró la tecnologia con id " + id);
        }

        if (!empleadoService.darBajaTecnologiaDeEmpleados(empleados, tecnologia)) {
            throw new TecnologiaErrorException("Hubo un error al dar de baja a la tecnologia por la relación con los empleados");
        }

        if (!proyectoService.darBajaTecnologiaDeProyectos(proyectos, tecnologia)) {
            throw new TecnologiaErrorException("Hubo un error al dar de baja a la tecnologia por la relación con los proyectos");
        }

        return ResponseEntity.ok(tecnologia);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Tecnologia> editarTecnologia(@RequestBody Tecnologia tecnologia) throws TecnologiaNotFoundException {
        Tecnologia editado = tecnologiaService.editar(tecnologia);

        if (tecnologia == null) {
            throw new TecnologiaNotFoundException("No se encontró la tecnologia con id " + tecnologia.getId());
        }

        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(TecnologiaNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(TecnologiaNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(TecnologiaErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(TecnologiaErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
