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

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private Cliente id_cliente_actual;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private CargoRHPRO id_cargo;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private CentroCosto id_centro_costo;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    private Usuario id_usuario;

    public Empleado() {}
/*
    public Empleado(int id, String nombre, int edad, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }
*/
    public int getId() {
        return id;
    }

    private void setId(int id) {
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

    public Cliente getIdClienteActual() {
        return id_cliente_actual;
    }

    public void setIdClienteActual(Cliente id_cliente_actual) {
        this.id_cliente_actual = id_cliente_actual;
    }

    public CargoRHPRO getIdCargo() {
        return id_cargo;
    }

    public void setIdCargo(CargoRHPRO id_cargo) {
        this.id_cargo = id_cargo;
    }

    public CentroCosto getIdCentroCosto() {
        return id_centro_costo;
    }

    public void setIdCentroCosto(CentroCosto id_centro_costo) {
        this.id_centro_costo = id_centro_costo;
    }

    public Usuario getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
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
