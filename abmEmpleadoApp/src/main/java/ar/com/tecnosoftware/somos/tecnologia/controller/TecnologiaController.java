package ar.com.tecnosoftware.somos.tecnologia.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.exception.TecnologiaErrorException;
import ar.com.tecnosoftware.somos.tecnologia.exception.TecnologiaNotFoundException;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
import ar.com.tecnosoftware.somos.tipoTecnologia.service.TipoTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
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

    @Autowired
    private TipoTecnologiaService tipoTecnologiaService;

    @PostMapping(value = "/crear")
    public String addTecnologia(@Valid @RequestBody Tecnologia tecnologia) throws TecnologiaErrorException {
        String resultado = tecnologiaService.add(tecnologia);
        if (!resultado.equals("")) {
            throw new TecnologiaErrorException(resultado);
        }
        return resultado;
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
    public ResponseEntity<Tecnologia> editarTecnologia(@Valid @RequestBody Tecnologia tecnologia) throws TecnologiaNotFoundException, TecnologiaErrorException {

        if (tecnologiaService.buscar(tecnologia.getTipo().getId()) == null) {
            throw new TecnologiaErrorException("No existe el Tipo de Tecnologia con id " + tecnologia.getTipo().getId());
        }

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> errorException(MethodArgumentNotValidException e) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }

}
