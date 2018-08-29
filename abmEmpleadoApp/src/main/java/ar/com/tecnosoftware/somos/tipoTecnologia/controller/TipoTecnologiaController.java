package ar.com.tecnosoftware.somos.tipoTecnologia.controller;

import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
import ar.com.tecnosoftware.somos.tipoTecnologia.entity.TipoTecnologia;
import ar.com.tecnosoftware.somos.tipoTecnologia.exception.TipoTecnologiaErrorException;
import ar.com.tecnosoftware.somos.tipoTecnologia.exception.TipoTecnologiaNotFoundException;
import ar.com.tecnosoftware.somos.tipoTecnologia.service.TipoTecnologiaService;
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
@RequestMapping("/tipoTecnologia")
public class TipoTecnologiaController {

    @Autowired
    private TipoTecnologiaService tipoTecnologiaService;

    @Autowired
    private TecnologiaService tecnologiaService;

    @PostMapping(value = "/crear")
    public void addTipoTecnologia(@RequestBody TipoTecnologia tipoTecnologia) {
        tipoTecnologiaService.add(tipoTecnologia);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<TipoTecnologia>> findTipoTecnologiaActivos() throws TipoTecnologiaErrorException {
        List<TipoTecnologia> tipoTecnologias = tipoTecnologiaService.buscarNoBajas();
        if (tipoTecnologias == null) {
            throw new TipoTecnologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tipoTecnologias);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<TipoTecnologia>> findAllTipoTecnologia() throws TipoTecnologiaErrorException {
        List<TipoTecnologia> tipoTecnologias = tipoTecnologiaService.buscarTodos();
        if (tipoTecnologias == null) {
            throw new TipoTecnologiaErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(tipoTecnologias);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<TipoTecnologia> bajaTipoTecnologia(@PathVariable int id, @RequestBody List<Tecnologia> tecnologias) throws TipoTecnologiaErrorException, TipoTecnologiaNotFoundException {

        TipoTecnologia tipoTecnologia = tipoTecnologiaService.darBaja(id);

        if (tipoTecnologia == null) {
            throw new TipoTecnologiaNotFoundException("No se encontró el tipo de tecnologia con id " + id);
        }

        if (!tecnologiaService.darBajaTipoTecnologiasDeTecnologias(tecnologias)) {
            throw new TipoTecnologiaErrorException("Hubo un error al dar de baja al tipo de tecnologia por la relación con las tecnologias. Puede que no exista el Tipo de Tecnologia por defecto.");
        }

        return ResponseEntity.ok(tipoTecnologia);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<TipoTecnologia> editarTipoTecnologia(@RequestBody TipoTecnologia tipoTecnologia) throws TipoTecnologiaNotFoundException {
        TipoTecnologia editado = tipoTecnologiaService.editar(tipoTecnologia);

        if (tipoTecnologia == null) {
            throw new TipoTecnologiaNotFoundException("No se encontró el tipo de tecnologia con id " + tipoTecnologia.getId());
        }
        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(TipoTecnologiaNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(TipoTecnologiaNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(TipoTecnologiaErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(TipoTecnologiaErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
