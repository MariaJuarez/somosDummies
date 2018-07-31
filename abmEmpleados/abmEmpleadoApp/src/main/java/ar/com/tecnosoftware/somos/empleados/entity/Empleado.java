package ar.com.tecnosoftware.somos.empleados.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 *
 * En hibernate es necesario tener en la clase entity siempre un constructor vacio.
 * tambien especificar el nombre de las tablas y columnas sin camelcase ya que varias DB
 * lo toman como un guion bajo. Es decir si se usa idEmpleado la DB lo toma como id_empleado
 * y crea conflicto.
 *
 **/

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

    @NotNull
    @ManyToOne(cascade={CascadeType.ALL})
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

    public Empleado(String nombre, int edad, double sueldo, Cliente cliente_actual, CargoRHPRO cargo, CentroCosto centro_costo, Usuario usuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", name='" + nombre + '\'' +
                ", edad=" + edad +
                ", sueldo=" + sueldo +
                '}';
    }
}
