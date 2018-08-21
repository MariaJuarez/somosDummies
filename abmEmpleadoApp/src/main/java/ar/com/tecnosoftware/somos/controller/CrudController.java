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

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private RubroService rubroService;

    @Autowired
    private TecnologiaService tecnologiaService;

    @Autowired
    private TipoTecnologiaService tipoTecnologiaService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private TipoProyectoService tipoProyectoService;

    @Autowired
    private MetodologiaService metodologiaService;

    @Autowired
    private ProyectoEmpleadoService proyectoEmpleadoService;

    /**
     *
     * @param empleado
     */
    @PostMapping (value = "/crear/empleado")
    public void addEmpleado(@Valid @RequestBody Empleado empleado) {
        empleadoService.add(empleado);
    }

    /**
     *
     * @param cliente
     */
    @PostMapping (value = "/crear/cliente")
    public void addCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    @PostMapping (value = "/crear/cargo")
    public void addCargo(@Valid @RequestBody Cargo cargo) {
        cargoService.add(cargo);
    }

    /**
     *
     * @param area
     */
    @PostMapping (value = "/crear/area")
    public void addArea(@Valid @RequestBody Area area) {
        areaService.add(area);
    }

    /**
     *
     * @param usuario
     */
    @PostMapping (value = "/crear/usuario")
    public void addUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.add(usuario);
    }

    @PostMapping (value = "/crear/perfil")
    public void addPerfil(@Valid @RequestBody Perfil perfil) {
        perfilService.add(perfil);
    }

    @PostMapping (value = "/crear/rubro")
    public void addRubro(@Valid @RequestBody Rubro rubro) {
        rubroService.add(rubro);
    }

    @PostMapping (value = "/crear/tecnologia")
    public void addTecnologia(@Valid @RequestBody Tecnologia tecnologia) {
        tecnologiaService.add(tecnologia);
    }

    @PostMapping (value = "/crear/tipoTecnologia")
    public void addTipoTecnologia(@Valid @RequestBody TipoTecnologia tipoTecnologia) {
        tipoTecnologiaService.add(tipoTecnologia);
    }

    @PostMapping (value = "/crear/proyecto")
    public void addProyecto(@Valid @RequestBody Proyecto proyecto) {
        proyectoService.add(proyecto);
    }

    @PostMapping (value = "/crear/tipoProyecto")
    public void addTipoProyecto(@Valid @RequestBody TipoProyecto tipoProyecto) {
        tipoProyectoService.add(tipoProyecto);
    }

    @PostMapping (value = "/crear/metodologia")
    public void addMetodologia(@Valid @RequestBody Metodologia metodologia) {
        metodologiaService.add(metodologia);
    }

    @PostMapping (value = "/crear/proyectoEmpleado")
    public void addProyectoEmpleado(@Valid @RequestBody ProyectoEmpleado proyectoEmpleado) {
        proyectoEmpleadoService.add(proyectoEmpleado);
    }

    @GetMapping (value = "/list/empleados")
    public List<Empleado> findAllEmpleado(){ return empleadoService.buscarTodos();}

    @GetMapping (value = "/list/clientes")
    public List<Cliente> findAllCliente(){ return clienteService.buscarTodos();}

    @GetMapping (value = "/list/cargos")
    public List<Cargo> findAllCargos(){ return cargoService.buscarTodos();}

    @GetMapping (value = "/list/areas")
    public List<Area> findAllArea(){
        return areaService.buscarTodos();
    }

    @GetMapping (value = "/list/usuarios")
    public List<Usuario> findAllUsuario(){ return usuarioService.buscarTodos();}

    @GetMapping (value = "/list/rubros")
    public List<Rubro> findAllRubro(){
        return rubroService.buscarTodos();
    }

    @GetMapping (value = "/list/perfiles")
    public List<Perfil> findAllPerfil(){
        return perfilService.buscarTodos();
    }

    @GetMapping (value = "/list/tecnologias")
    public List<Tecnologia> findAllTecnologia(){
        return tecnologiaService.buscarTodos();
    }

    @GetMapping (value = "/list/tiposTecnologia")
    public List<TipoTecnologia> findAllTipoTecnologia(){
        return tipoTecnologiaService.buscarTodos();
    }

    @GetMapping (value = "/list/proyectos")
    public List<Proyecto> findAllProyecto(){
        return proyectoService.buscarTodos();
    }

    @GetMapping (value = "/list/tiposProyecto")
    public List<TipoProyecto> findAllTipoProyecto(){
        return tipoProyectoService.buscarTodos();
    }

    @GetMapping (value = "/list/proyectosEmpleados")
    public List<ProyectoEmpleado> findAllProyectoEmpleado(){
        return proyectoEmpleadoService.buscarTodos();
    }

    @GetMapping (value = "/list/metodologias")
    public List<Metodologia> findAllMetodologia(){
        return metodologiaService.buscarTodos();
    }

    @PutMapping (value = "/baja/empleado/{id}")
    public void bajaEmpleado(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) {
        proyectoEmpleadoService.darBajaProyectosEmpleados(proyectoEmpleados);
        empleadoService.darBaja(id);
    }

    @PutMapping (value = "/baja/empleadoDeUsuario")
    public void bajaUsuarioConEmpleado(@RequestBody Usuario usuario) {
        usuarioService.darBajaEmpleadoDeUsuario(usuario);
    }

    @PutMapping (value = "/baja/cliente/{id}")
    public void bajaCliente(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaProyectos(proyectos);
        clienteService.darBaja(id);
    }

    @PutMapping (value = "/baja/cargo/{id}")
    public void bajaCargo(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectoEmpleados) {
        proyectoEmpleadoService.darBajaCargoDeProyectosEmpleados(proyectoEmpleados);
        cargoService.darBaja(id);
    }

    @PutMapping (value = "/baja/proyectoEmpleado/{id}")
    public void bajaProyectoEmpleado(@PathVariable int id) {
        proyectoEmpleadoService.darBaja(id);
    }

    @PutMapping (value = "/baja/area/{id}")
    public void bajaArea(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaAreaDeEmpleados(empleados);
        areaService.darBaja(id);
    }

    @PutMapping (value = "/baja/usuario/{id}")
    public void bajaUsuario(@PathVariable int id) {
        usuarioService.darBaja(id);
    }

    @PutMapping (value = "/baja/perfil/{id}")
    public void bajaPerfil(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaPerfilDeEmpleados(empleados);
        perfilService.darBaja(id);
    }

    @PutMapping (value = "/baja/rubro/{id}")
    public void bajaRubro(@PathVariable int id, @RequestBody List<Cliente> clientes) {
        clienteService.darBajaRubroDeClientes(clientes);
        rubroService.darBaja(id);
    }

    @PutMapping (value = "/baja/tecnologia/{id}")
    public void bajaTecnologia(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaTecnologiaDeEmpleados(empleados, id);
        tecnologiaService.darBaja(id);
    }

    @PutMapping (value = "/baja/tecnologiaConProyecto/{id}")
    public void bajaTecnologiaDeProyecto(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaTecnologiaDeProyectos(proyectos, id);
    }

    @PutMapping (value = "/baja/tipoTecnologia/{id}")
    public void bajaTipoTecnologia(@PathVariable int id, @RequestBody List<Tecnologia> tecnologias) {
        tecnologiaService.darBajaTipoTecnologiasDeTecnologias(tecnologias);
        tipoTecnologiaService.darBaja(id);
    }

    @PutMapping (value = "/baja/proyecto/{id}")
    public void bajaProyecto(@PathVariable int id, @RequestBody List<ProyectoEmpleado> proyectosEmpleados) {
        proyectoEmpleadoService.darBajaProyectosEmpleados(proyectosEmpleados);
        proyectoService.darBaja(id);
    }

    @PutMapping (value = "/baja/tipoProyecto/{id}")
    public void bajaTipoProyecto(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaTipoProyectoDeProyectos(proyectos);
        tipoProyectoService.darBaja(id);
    }

    @PutMapping (value = "/baja/metodologia/{id}")
    public void bajaMetodologia(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaMetodologiaDeProyectos(proyectos);
        metodologiaService.darBaja(id);
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