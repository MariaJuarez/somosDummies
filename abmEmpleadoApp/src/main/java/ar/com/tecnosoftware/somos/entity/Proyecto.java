package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Proyecto implements Serializable {
    private int idProyecto;
    private String jira;
    private int crm;
    private String nombre;
    private String lider;
    private String objetivo;
    private boolean externo;
    private String equipoTrabajo;
    private Date fechaInicio;
    private Date fechaFin;
    private String usuarios;
    private String areaSolicitante;
    private String roles;
    private String reqFuncional;
    private String observaciones;
    private boolean promovidoLps;
    private Cliente cliente;
    private Metodologia metodologia;
    private TipoProyecto tipoProyecto;
    private List<ProyectoEmpleado> proyectosEmpleado;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProyecto")
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Basic
    @Column(name = "JIRA")
    public String getJira() {
        return jira;
    }

    public void setJira(String jira) {
        this.jira = jira;
    }

    @Basic
    @Column(name = "CRM")
    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    @Basic
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Lider")
    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Basic
    @Column(name = "Objetivo")
    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Basic
    @Column(name = "Externo")
    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    @Basic
    @Column(name = "EquipoTrabajo")
    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    @Basic
    @Column(name = "FechaInicio")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "FechaFin")
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "Usuarios")
    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    @Basic
    @Column(name = "AreaSolicitante")
    public String getAreaSolicitante() {
        return areaSolicitante;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
    }

    @Basic
    @Column(name = "Roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "ReqFuncional")
    public String getReqFuncional() {
        return reqFuncional;
    }

    public void setReqFuncional(String reqFuncional) {
        this.reqFuncional = reqFuncional;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return idProyecto == proyecto.idProyecto &&
                crm == proyecto.crm &&
                externo == proyecto.externo &&
                promovidoLps == proyecto.promovidoLps &&
                Objects.equals(jira, proyecto.jira) &&
                Objects.equals(nombre, proyecto.nombre) &&
                Objects.equals(lider, proyecto.lider) &&
                Objects.equals(objetivo, proyecto.objetivo) &&
                Objects.equals(equipoTrabajo, proyecto.equipoTrabajo) &&
                Objects.equals(fechaInicio, proyecto.fechaInicio) &&
                Objects.equals(fechaFin, proyecto.fechaFin) &&
                Objects.equals(usuarios, proyecto.usuarios) &&
                Objects.equals(areaSolicitante, proyecto.areaSolicitante) &&
                Objects.equals(roles, proyecto.roles) &&
                Objects.equals(reqFuncional, proyecto.reqFuncional) &&
                Objects.equals(observaciones, proyecto.observaciones);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idProyecto, jira, crm, nombre, lider, objetivo, externo, equipoTrabajo, fechaInicio, fechaFin, usuarios, areaSolicitante, roles, reqFuncional, observaciones, promovidoLps);
    }

    @OneToOne
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToOne
    @JoinColumn(name = "IdMetodologia", referencedColumnName = "IdMetodologia")
    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    @OneToOne
    @JoinColumn(name = "IdTipoProyecto", referencedColumnName = "IdTipoProyecto")
    public TipoProyecto getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    @Transient
    @OneToMany(mappedBy = "proyecto")
    public List<ProyectoEmpleado> getProyectosEmpleado() {
        return proyectosEmpleado;
    }

    public void setProyectosEmpleado(List<ProyectoEmpleado> proyectosEmpleado) {
        this.proyectosEmpleado = proyectosEmpleado;
    }
}
