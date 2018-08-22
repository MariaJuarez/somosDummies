package ar.com.tecnosoftware.somos.metodologia.controller;

import ar.com.tecnosoftware.somos.metodologia.entity.Metodologia;
import ar.com.tecnosoftware.somos.metodologia.service.MetodologiaService;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/metodologia")
public class MetodologiaController {

    @Autowired
    private MetodologiaService metodologiaService;

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping(value = "/crear")
    public void addMetodologia(@Valid @RequestBody Metodologia metodologia) {
        metodologiaService.add(metodologia);
    }

    @GetMapping (value = "/listar")
    public List<Metodologia> findAllMetodologia(){
        return metodologiaService.buscarTodos();
    }

    @PutMapping (value = "/baja/{id}")
    public void bajaMetodologia(@PathVariable int id, @RequestBody List<Proyecto> proyectos) {
        proyectoService.darBajaMetodologiaDeProyectos(proyectos);
        metodologiaService.darBaja(id);
    }

}
