package ar.com.tecnosoftware.somos.proyectoEmpleado.util;

import ar.com.tecnosoftware.somos.empleado.entity.Empleado;
import ar.com.tecnosoftware.somos.filtro.FiltroEmpleado;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ProyectoEmpleadoFiltroUtil {
    /*
    Devuelve un numero y cada numero representa una combinacion de filtros
        0-Sin Filtro
        1-Proyecto
        2-TipoProyecto
        3-Clientes
        4-Rubro
        5-TipoProyecto y Clientes
        6-TipoProyecto y Rubro
        7-Clientes y Rubro
        9-TipoProyecto, Clientes y Rubro
    */
    public static int filtrosProyectoEmpleado(FiltroEmpleado filtroEmpleado){

        int tipoFiltro = 0;

        if(filtroEmpleado.getProyecto() == null){

            if(filtroEmpleado.getTipoProyecto() != null){
                tipoFiltro += 2;
            }

            if(filtroEmpleado.getClientes() != null){
                tipoFiltro += 3;
            }

            if(filtroEmpleado.getRubro() != null){
                tipoFiltro += 4;
            }

        } else {
            return 1;
        }

        return tipoFiltro;
    }

    public static String armarQuery(int tipoFiltro){

        String hql = "SELECT DISTINCT (pe.empleado) FROM ProyectoEmpleado pe ";

        switch (tipoFiltro){
            case 1:
                hql += "WHERE pe.proyecto = :proyecto";
                break;
            case 2:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.tipo = :tipoProyecto)";
                break;
            case 3:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.cliente IN (FROM Cliente c " +
                                                                "WHERE c.id IN :clientes))";
                break;
            case 4:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.cliente IN (FROM Cliente c " +
                                                                "WHERE c.rubro = :rubro))";
                break;
            case 5:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.tipo = :tipoProyecto AND p.cliente IN (FROM Cliente c " +
                                                                                            "WHERE c.id IN :clientes))";
                break;
            case 6:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.tipo = :tipoProyecto AND p.cliente IN (FROM Cliente c " +
                                                                                            "WHERE c.rubro = :rubro))";
                break;
            case 7:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.cliente IN (FROM Cliente c " +
                                                                "WHERE c.rubro = :rubro AND c.id IN :clientes))";
                break;
            case 9:
                hql += "WHERE pe.proyecto IN (FROM Proyecto p " +
                                            "WHERE p.tipo = :tipoProyecto AND p.cliente IN (FROM Cliente c " +
                                                                                            "WHERE c.rubro = :rubro AND c.id IN :clientes))";
                break;
        }

        return hql;
    }

    public static List<Empleado> filtroPorEmpleadoPorProyecto(List<Empleado> filtroPorEmpleado, List<Empleado> filtroPorProyecto){
        List<Empleado> resultado = new ArrayList<>(filtroPorProyecto);
        resultado.retainAll(filtroPorEmpleado);
        return resultado;
    }

}
