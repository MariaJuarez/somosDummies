package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Data {
    private int idData;
    private double año;
    private double mes;
    private double legajo;
    private double facturacion;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idData")
    public int getIdData() {
        return idData;
    }

    public void setIdData(int idData) {
        this.idData = idData;
    }

    @Basic
    @Column(name = "Año")
    public double getAño() {
        return año;
    }

    public void setAño(double año) {
        this.año = año;
    }

    @Basic
    @Column(name = "Mes")
    public double getMes() {
        return mes;
    }

    public void setMes(double mes) {
        this.mes = mes;
    }

    @Basic
    @Column(name = "legajo")
    public double getLegajo() {
        return legajo;
    }

    public void setLegajo(double legajo) {
        this.legajo = legajo;
    }

    @Basic
    @Column(name = "Facturacion")
    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Double.compare(data.año, año) == 0 &&
                Double.compare(data.mes, mes) == 0 &&
                Double.compare(data.legajo, legajo) == 0 &&
                Double.compare(data.facturacion, facturacion) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(año, mes, legajo, facturacion);
    }
}
