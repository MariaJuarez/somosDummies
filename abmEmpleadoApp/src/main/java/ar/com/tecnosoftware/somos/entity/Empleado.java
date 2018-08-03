package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Empleado {
    private int idEmpleado;
    private int legajo;
    private String nombres;
    private String apellidos;
    private String responsable;
    private Date fehaIngreso;
    private Date fechaEgreso;
    private String domicilioLaboral;
    private String observaciones;
    private boolean promovidoLps;
    private boolean activo;
    private String email;
    private String telefono;
    private Cliente clienteEmpleado;
    private Areas cargo;
    private Area area;
    private Usuario usuario;
    private List<ProyectoEmpleado> proyectosEmpleado;

    @Id
    @Column(name = "IdEmpleado")
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "Legajo")
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Basic
    @Column(name = "Nombres")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "Apellidos")
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "Responsable")
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Basic
    @Column(name = "FehaIngreso")
    public Date getFehaIngreso() {
        return fehaIngreso;
    }

    public void setFehaIngreso(Date fehaIngreso) {
        this.fehaIngreso = fehaIngreso;
    }

    @Basic
    @Column(name = "FechaEgreso")
    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    @Basic
    @Column(name = "DomicilioLaboral")
    public String getDomicilioLaboral() {
        return domicilioLaboral;
    }

    public void setDomicilioLaboral(String domicilioLaboral) {
        this.domicilioLaboral = domicilioLaboral;
    }

    @Basic
    @Column(name = "Observaciones")
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Basic
    @Column(name = "PromovidoLPS")
    public boolean isPromovidoLps() {
        return promovidoLps;
    }

    public void setPromovidoLps(boolean promovidoLps) {
        this.promovidoLps = promovidoLps;
    }

    @Basic
    @Column(name = "Activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return idEmpleado == empleado.idEmpleado &&
                legajo == empleado.legajo &&
                promovidoLps == empleado.promovidoLps &&
                activo == empleado.activo &&
                Objects.equals(nombres, empleado.nombres) &&
                Objects.equals(apellidos, empleado.apellidos) &&
                Objects.equals(responsable, empleado.responsable) &&
                Objects.equals(fehaIngreso, empleado.fehaIngreso) &&
                Objects.equals(fechaEgreso, empleado.fechaEgreso) &&
                Objects.equals(domicilioLaboral, empleado.domicilioLaboral) &&
                Objects.equals(observaciones, empleado.observaciones) &&
                Objects.equals(email, empleado.email) &&
                Objects.equals(telefono, empleado.telefono);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idEmpleado, legajo, nombres, apellidos, responsable, fehaIngreso, fechaEgreso, domicilioLaboral, observaciones, promovidoLps, activo, email, telefono);
    }

    @ManyToOne
    @JoinColumn(name = "IdEmpleado", referencedColumnName = "IdEmpleadoComercial", nullable = false)
    public Cliente getClienteEmpleado() {
        return clienteEmpleado;
    }

    public void setClienteEmpleado(Cliente clienteEmpleado) {
        this.clienteEmpleado = clienteEmpleado;
    }

    @OneToOne
    @JoinColumn(name = "IdCargo", referencedColumnName = "IdCargoRHPRO")
    public Areas getCargo() {
        return cargo;
    }

    public void setCargo(Areas cargo) {
        this.cargo = cargo;
    }

    @OneToOne
    @JoinColumn(name = "IdCentroCosto", referencedColumnName = "IdCentroCosto")
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @OneToOne
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdEmpleado")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToMany(mappedBy = "empleado")
    public List<ProyectoEmpleado> getProyectosEmpleado() {
        return proyectosEmpleado;
    }

    public void setProyectosEmpleado(List<ProyectoEmpleado> proyectosEmpleado) {
        this.proyectosEmpleado = proyectosEmpleado;
    }
}
