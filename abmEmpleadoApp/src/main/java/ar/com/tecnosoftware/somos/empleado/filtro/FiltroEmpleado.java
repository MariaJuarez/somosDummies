package ar.com.tecnosoftware.somos.empleado.filtro;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.cliente.entity.Cliente;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FiltroEmpleado {
    //Empleado
    private Boolean baja = null;

    private Integer legajo = null;

    private String nombres = null;

    private String apellidos = null;

    private Date fechaIngreso = null;

    private Date fechaEgreso = null;

    private Boolean promovidoLps = null;

    private Area area = null;

    //Debe pasar una lista con los Id de las tecnologias deseadas
    private List<Integer> tecnologias = null;

    //Proyecto
    private Rubro rubro = null;

    private TipoProyecto tipoProyecto = null;

    private Cliente cliente = null;

    private Proyecto proyecto = null;

    private Date anioLps = null;
}
