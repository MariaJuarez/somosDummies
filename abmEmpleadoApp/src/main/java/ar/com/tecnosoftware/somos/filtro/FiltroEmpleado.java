package ar.com.tecnosoftware.somos.filtro;

import ar.com.tecnosoftware.somos.area.entity.Area;
import ar.com.tecnosoftware.somos.proyecto.entity.Proyecto;
import ar.com.tecnosoftware.somos.rubro.entity.Rubro;
import ar.com.tecnosoftware.somos.tecnologia.entity.Tecnologia;
import ar.com.tecnosoftware.somos.tipoProyecto.entity.TipoProyecto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
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

    //Debe pasar una lista con el objeto COMPLETO de la tecnologias deseadas
    //Si no se envia algun atributo de tecnologia, no hará correctamente el filtro
    private List<Tecnologia> tecnologias = null;

    //Filtro por Proyecto, se pueden enviar el objeto inicializando solo el id
    private Rubro rubro = null;

    private TipoProyecto tipoProyecto = null;

    //Solo enviar lista de enteros, nada de objetos
    private List<Integer> clientes = null;

    private Proyecto proyecto = null;
}