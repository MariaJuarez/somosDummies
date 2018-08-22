package ar.com.tecnosoftware.somos.tipoProyecto.controller;

import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import ar.com.tecnosoftware.somos.tipoProyecto.service.TipoProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tipoProyecto")
public class TipoProyectoController {

    @Autowired
    private TipoProyectoService tipoProyectoService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addTipoProyecto(@Valid @RequestBody TipoProyecto tipoProyecto) {
        tipoProyectoService.add(tipoProyecto);
    }

    @GetMapping (value = "/listar")
    public List<TipoProyecto> findAllTipoProyecto(){
        return tipoProyectoService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaTipoProyecto(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaTipoProyectoDeProyectos(proyectos);
        tipoProyectoService.darBaja(id);
    }

}
