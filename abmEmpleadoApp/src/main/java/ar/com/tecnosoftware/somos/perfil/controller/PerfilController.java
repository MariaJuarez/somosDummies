package ar.com.tecnosoftware.somos.perfil.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.exception.PerfilErrorException;
import ar.com.tecnosoftware.somos.perfil.exception.PerfilNotFoundException;
import ar.com.tecnosoftware.somos.perfil.service.PerfilService;
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
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addPerfil(@RequestBody Perfil perfil) {
        perfilService.add(perfil);
    }

    @GetMapping(value = "/listarActivos")
    public ResponseEntity<List<Perfil>> findPerfilActivos() throws PerfilErrorException {
        List<Perfil> perfiles = perfilService.buscarNoBajas();
        if (perfiles == null) {
            throw new PerfilErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(perfiles);
    }

    @GetMapping(value = "/listarTodos")
    public ResponseEntity<List<Perfil>> findAllPerfil() throws PerfilErrorException {
        List<Perfil> perfiles = perfilService.buscarTodos();
        if (perfiles == null) {
            throw new PerfilErrorException("Hubo un error al cargar la BD. Revise su conexión a la BD");
        }
        return ResponseEntity.ok(perfiles);
    }

    @PutMapping(value = "/baja/{id}")
    @Transactional
    public ResponseEntity<Perfil> bajaPerfil(@PathVariable int id, @RequestBody List<Empleado> empleados) throws PerfilErrorException, PerfilNotFoundException {
        empleadoService.darBajaPerfilDeEmpleados(empleados);

        Perfil perfil = perfilService.darBaja(id);

        if (perfil == null) {
            throw new PerfilNotFoundException("No se encontró el perfil con id " + id);
        }

        if (!empleadoService.darBajaPerfilDeEmpleados(empleados)) {
            throw new PerfilErrorException("Hubo un error al dar de baja al perfil por la relación con los empleados. Puede que no exista el Perfil por defecto.");
        }

        return ResponseEntity.ok(perfil);
    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Perfil> editarPerfil(@RequestBody Perfil perfil) throws PerfilNotFoundException {
        Perfil perfil1Editado = perfilService.editar(perfil);

        if (perfil1Editado == null) {
            throw new PerfilNotFoundException("No se encontró el perfil con id " + perfil.getId());
        }

        return ResponseEntity.ok(perfil1Editado);

    }

    @ExceptionHandler(PerfilNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(PerfilNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(PerfilErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(PerfilErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
