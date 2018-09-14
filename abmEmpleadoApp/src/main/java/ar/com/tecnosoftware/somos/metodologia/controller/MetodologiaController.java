package ar.com.tecnosoftware.somos.metodologia.controller;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.metodologia.exception.MetodologiaErrorException;
import ar.com.tecnosoftware.somos.metodologia.exception.MetodologiaNotFoundException;
import ar.com.tecnosoftware.somos.metodologia.service.MetodologiaService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
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
@RequestMapping("/metodologia")
public class MetodologiaController {

    @Autowired
    private MetodologiaService metodologiaService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public String addMetodologia(@Valid @RequestBody Metodologia metodologia) {
        return metodologiaService.add(metodologia);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Metodologia>> findMetodologiaActivos() throws MetodologiaErrorException {
        List<Metodologia> metodologias = metodologiaService.buscarNoBajas();
        if (metodologias == null) {
            throw new MetodologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(metodologias);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Metodologia>> findAllMetodologia() throws MetodologiaErrorException {

        List<Metodologia> metodologias = metodologiaService.buscarTodos();
        if (metodologias == null) {
            throw new MetodologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(metodologias);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Metodologia> bajaMetodologia(@PathVariable int id) throws MetodologiaNotFoundException, MetodologiaErrorException {
        Metodologia metodologia = metodologiaService.darBaja(id);

        if (metodologia == null) {
            throw new MetodologiaNotFoundException("No se encontró la metodologia con id " + id);
        }



        return ResponseEntity.ok(metodologia);

    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Metodologia> editarMetodologia(@Valid @RequestBody Metodologia metodologia) throws MetodologiaNotFoundException {

        Metodologia metodologiaEditado = metodologiaService.editar(metodologia);
        if (metodologiaEditado == null) {
            throw new MetodologiaNotFoundException("No se encontró la metodologia con id " + metodologia.getId());
        }
        return ResponseEntity.ok(metodologia);
    }

    @ExceptionHandler(MetodologiaNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(MetodologiaNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(MetodologiaErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(MetodologiaErrorException e) {
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
