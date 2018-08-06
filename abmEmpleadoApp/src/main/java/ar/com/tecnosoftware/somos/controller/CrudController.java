package ar.com.tecnosoftware.somos.controller;

import ar.com.tecnosoftware.somos.entity.*;
import ar.com.tecnosoftware.somos.entity.Cargo;
import ar.com.tecnosoftware.somos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 * Controler CRUD

 * @version: 25/07/2018/A

 */


@RestController
@CrossOrigin
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private UsuarioService usuarioService;

    /**
     *
     * @param empleado
     */
    @PostMapping (value = "/crear/empleado")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.addEmpleado(empleado);
    }

    /**
     *
     * @param cliente
     */
    @PostMapping (value = "/crear/cliente")
    public void addCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    @PostMapping (value = "/crear/cargo")
    public void addCargo(@Valid @RequestBody Cargo cargo) {
        cargoService.addCargo(cargo);
    }

    /**
     *
     * @param area
     */
    @PostMapping (value = "/crear/area")
    public void addArea(@Valid @RequestBody Area area) {
        areaService.addArea(area);
    }

    /**
     *
     * @param usuario
     */
    @PostMapping (value = "/crear/usuario")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.addUsuario(usuario);
    }

    @GetMapping (value = "/list/empleado")
    public List<Empleado> findAllEmpleado(){ return empleadoService.buscarTodos();}

    @GetMapping (value = "/list/cliente")
    public List<Cliente> findAllCliente(){ return clienteService.buscarTodos();}

    @GetMapping (value = "/list/cargo")
    public List<Cargo> findAllCargos(){ return cargoService.buscarTodos();}

    @GetMapping (value = "/list/area")
    public List<Area> findAllArea(){ return areaService.buscarTodos();}

    @GetMapping (value = "/list/usuario")
    public List<Usuario> findAllUsuario(){ return usuarioService.buscarTodos();}

    @DeleteMapping (value = "/baja/empleado/{id}")
    public void bajaEmpleado(@RequestParam int id) {
        empleadoService.darBaja(id);
    }

    @DeleteMapping (value = "/baja/cliente/{id}")
    public void bajaCliente(@RequestParam int id) {
        clienteService.darBaja(id);
    }

    @DeleteMapping (value = "/baja/cargo/{id}")
    public void bajaCargo(@RequestParam int id) {
        cargoService.darBaja(id);
    }

    @DeleteMapping (value = "/baja/area/{id}")
    public void bajaArea(@RequestParam int id) {
        areaService.darBaja(id);
    }

    @DeleteMapping (value = "/baja/usuario/{id}")
    public void bajaUsuario(@RequestParam int id) {
        usuarioService.darBaja(id);
    }

    /**
     *
     * @param ex
     * @return Excepción que se lanzará cuando la validación de un argumento anotado con
     * {@code @Valid} falla.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }

    /**
     *
     * @param ex
     * @return Lanzado cuando los errores de enlace se consideran fatales. Implementa el
     * BindingResult interfaz (y su super-interfaz Errors)
     * para permitir el análisis directo de errores vinculantes.
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> validationError(BindException ex) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        errors.put("errores", map);
        return errors;
    }


}