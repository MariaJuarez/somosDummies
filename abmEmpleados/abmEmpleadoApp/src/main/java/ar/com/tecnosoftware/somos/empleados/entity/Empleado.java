package ar.com.tecnosoftware.somos.empleados.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Min(value = 18, message = "Debe ser mayor de edad")
    @Max(value = 80, message = "Edad fuera del rango correcto, debe estar entre los 18 y 80 años")
    @Column(name="edad")
    private int edad;

    @NotNull
    @DecimalMin("8000")
    @DecimalMax("1000000.00")
    @Column(name="sueldo")
    private double sueldo;

    @NotBlank
    @Column(name="baja")
    private boolean baja;

    @NotBlank
    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_baja")
    private Date fechaBaja;

    @NotNull
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private Cliente cliente_actual;

    @NotNull
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private CargoRHPRO cargo;

    @NotNull
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private CentroCosto centro_costo;

    @NotNull
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private Usuario usuario;

    public Empleado() {}

    public Empleado(String nombre, int edad, double sueldo, boolean baja, Date fechaAlta, Date fechaBaja, Cliente cliente_actual, CargoRHPRO cargo, CentroCosto centro_costo, Usuario usuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.baja = baja;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.cliente_actual = cliente_actual;
        this.cargo = cargo;
        this.centro_costo = centro_costo;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Cliente getCliente_actual() {
        return cliente_actual;
    }

    public void setCliente_actual(Cliente cliente_actual) {
        this.cliente_actual = cliente_actual;
    }

    public CargoRHPRO getCargo() {
        return cargo;
    }

    public void setCargo(CargoRHPRO cargo) {
        this.cargo = cargo;
    }

    public CentroCosto getCentro_costo() {
        return centro_costo;
    }

    public void setCentro_costo(CentroCosto centro_costo) {
        this.centro_costo = centro_costo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

}
