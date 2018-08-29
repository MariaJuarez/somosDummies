package ar.com.tecnosoftware.somos.tipoProyecto.controller;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.exception.TipoProyectoErrorException;
import ar.com.tecnosoftware.somos.tipoProyecto.exception.TipoProyectoNotFoundException;
import ar.com.tecnosoftware.somos.tipoProyecto.service.TipoProyectoService;
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
@RequestMapping("/tipoProyecto")
public class TipoProyectoController {

    @Autowired
    private TipoProyectoService tipoProyectoService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addTipoProyecto(@RequestBody TipoProyecto tipoProyecto) {
        tipoProyectoService.add(tipoProyecto);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<TipoProyecto>> findTipoProyectoActivos() throws TipoProyectoErrorException {
        List<TipoProyecto> tipoProyectos = tipoProyectoService.buscarNoBajas();
        if (tipoProyectos == null) {
            throw new TipoProyectoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tipoProyectos);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<TipoProyecto>> findAllTipoProyecto() throws TipoProyectoErrorException {
        List<TipoProyecto> tipoProyectos = tipoProyectoService.buscarTodos();
        if (tipoProyectos == null) {
            throw new TipoProyectoErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tipoProyectos);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<TipoProyecto> bajaTipoProyecto(@PathVariable int id, @RequestBody List<Proyecto> proyectos) throws TipoProyectoErrorException, TipoProyectoNotFoundException {

        TipoProyecto tipoProyecto = tipoProyectoService.darBaja(id);

        if (tipoProyecto == null) {
            throw new TipoProyectoNotFoundException("No se encontró el tipo de proyecto con id " + id);
        }

        if (!proyectoService.darBajaTipoProyectoDeProyectos(proyectos)) {
            throw new TipoProyectoErrorException("Hubo un error al dar de baja al tipo de proyecto por la relación con los proyectos. Puede que el TipoDeProyecto por defecto no existe.");
        }

        return ResponseEntity.ok(tipoProyecto);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<TipoProyecto> editarTipoProyecto(@RequestBody TipoProyecto tipoProyecto) throws TipoProyectoNotFoundException {
        TipoProyecto editado = tipoProyectoService.editar(tipoProyecto);

        if (tipoProyecto == null) {
            throw new TipoProyectoNotFoundException("No se encontró el tipo de proyecto con id " + tipoProyecto.getId());
        }

        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(TipoProyectoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(TipoProyectoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(TipoProyectoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(TipoProyectoErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }
}
