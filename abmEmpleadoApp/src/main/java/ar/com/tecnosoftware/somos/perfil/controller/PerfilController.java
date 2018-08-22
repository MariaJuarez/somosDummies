package ar.com.tecnosoftware.somos.perfil.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.perfil.entity.Perfil;
import ar.com.tecnosoftware.somos.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addPerfil(@Valid @RequestBody Perfil perfil) {
        perfilService.add(perfil);
    }

    @GetMapping (value = "/listar")
    public List<Perfil> findAllPerfil(){
        return perfilService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaPerfil(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaPerfilDeEmpleados(empleados);
        perfilService.darBaja(id);
    }

}
