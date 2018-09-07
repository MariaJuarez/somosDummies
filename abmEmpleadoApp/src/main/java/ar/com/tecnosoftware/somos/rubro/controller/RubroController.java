package ar.com.tecnosoftware.somos.rubro.controller;

import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.cliente.service.ClienteService;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.rubro.exception.RubroErrorException;
import ar.com.tecnosoftware.somos.rubro.exception.RubroNotFoundException;
import ar.com.tecnosoftware.somos.rubro.service.RubroService;
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
@RequestMapping("/rubro")
public class RubroController {

    @Autowired
    private RubroService rubroService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/crear")
    public String addRubro(@Valid @RequestBody Rubro rubro) {
        return rubroService.add(rubro);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Rubro>> findRubroActivo() throws RubroErrorException {
        List<Rubro> rubros = rubroService.buscarNoBajas();
        if (rubros == null) {
            throw new RubroErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(rubros);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Rubro>> findAllRubro() throws RubroErrorException {
        List<Rubro> rubros = rubroService.buscarTodos();
        if (rubros == null) {
            throw new RubroErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(rubros);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Rubro> bajaRubro(@PathVariable int id, @RequestBody List<Cliente> clientes) throws RubroErrorException, RubroNotFoundException {
        Rubro rubro = rubroService.darBaja(id);

        if (rubro == null) {
            throw new RubroNotFoundException("No se encontró el rubro con id " + id);
        }

        if (!clienteService.darBajaRubroDeClientes(clientes)) {
            throw new RubroErrorException("Hubo un error al dar de baja al rubro por la relación con los clientes. Puede que no existe el Rubro por defecto.");
        }

        return ResponseEntity.ok(rubro);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Rubro> editarRubro(@Valid @RequestBody Rubro rubro) throws RubroNotFoundException {

        Rubro editado = rubroService.editar(rubro);

        if (editado == null) {
            throw new RubroNotFoundException("No se encontró el rubro con id " + rubro.getId());
        }

        return ResponseEntity.ok(editado);
    }

    @ExceptionHandler(RubroNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(RubroNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(RubroErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(RubroErrorException e) {
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
