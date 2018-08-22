package ar.com.tecnosoftware.somos.tecnologia.controller;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.empleado.service.EmpleadoService;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tecnologia.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tecnologia")
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value = "/crear")
    public void addTecnologia(@Valid @RequestBody Tecnologia tecnologia) {
        tecnologiaService.add(tecnologia);
    }

    @GetMapping (value = "/listar")
    public List<Tecnologia> findAllTecnologia(){
        return tecnologiaService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaTecnologia(@PathVariable int id, @RequestBody List<Empleado> empleados) {
        empleadoService.darBajaTecnologiaDeEmpleados(empleados, id);
        tecnologiaService.darBaja(id);
    }

}
