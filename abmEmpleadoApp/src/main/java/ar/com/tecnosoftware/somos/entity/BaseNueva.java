package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class BaseNueva implements Serializable {
    private int id;
    private double legajo;
    private String apellidos;
    private String nombres;
    private Date relevado;
    private double añoLps;
    private String peopleCare;
    private String clienteActual;
    private String domicilioLaboral;
    private String observacionesEmpleado;
    private String nombreResponsable;
    private String nombreProyecto;
    private String observacionesProyecto;
    private String liderProyecto;
    private String objetivoProyecto;
    private String internoExterno;
    private String equipoTrabajo;
    private Date fechaInicio;
    private Date fechaFin;
    private String areaSolicitante;
    private String usuarios;
    private String rolesAreasInvolucradas;
    private String requerimientosFuncionales;
    private String requerimientosnofuncionales;
    private String lenguajesProgramacion;
    private String frameworks;
    private String basesDatos;
    private String herramientasDesarrollo;
    private String servidoresAplicaciones;
    private String perfil;
    private String tareasProyecto;
    private String metodologias;
    private String documentacion;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private String puestoRhpro;
    private String centroCosto;
    private String promovidoLps;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Legajo")
    public double getLegajo() {
        return legajo;
    }

    public void setLegajo(double legajo) {
        this.legajo = legajo;
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
    @Column(name = "Nombres")
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "Relevado")
    public Date getRelevado() {
        return relevado;
    }

    public void setRelevado(Date relevado) {
        this.relevado = relevado;
    }

    @Basic
    @Column(name = "AñoLPS")
    public double getAñoLps() {
        return añoLps;
    }

    public void setAñoLps(double añoLps) {
        this.añoLps = añoLps;
    }

    @Basic
    @Column(name = "PeopleCare")
    public String getPeopleCare() {
        return peopleCare;
    }

    public void setPeopleCare(String peopleCare) {
        this.peopleCare = peopleCare;
    }

    @Basic
    @Column(name = "ClienteActual")
    public String getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(String clienteActual) {
        this.clienteActual = clienteActual;
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
    @Column(name = "ObservacionesEmpleado")
    public String getObservacionesEmpleado() {
        return observacionesEmpleado;
    }

    public void setObservacionesEmpleado(String observacionesEmpleado) {
        this.observacionesEmpleado = observacionesEmpleado;
    }

    @Basic
    @Column(name = "NombreResponsable")
    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    @Basic
    @Column(name = "NombreProyecto")
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Basic
    @Column(name = "ObservacionesProyecto")
    public String getObservacionesProyecto() {
        return observacionesProyecto;
    }

    public void setObservacionesProyecto(String observacionesProyecto) {
        this.observacionesProyecto = observacionesProyecto;
    }

    @Basic
    @Column(name = "LiderProyecto")
    public String getLiderProyecto() {
        return liderProyecto;
    }

    public void setLiderProyecto(String liderProyecto) {
        this.liderProyecto = liderProyecto;
    }

    @Basic
    @Column(name = "ObjetivoProyecto")
    public String getObjetivoProyecto() {
        return objetivoProyecto;
    }

    public void setObjetivoProyecto(String objetivoProyecto) {
        this.objetivoProyecto = objetivoProyecto;
    }

    @Basic
    @Column(name = "InternoExterno")
    public String getInternoExterno() {
        return internoExterno;
    }

    public void setInternoExterno(String internoExterno) {
        this.internoExterno = internoExterno;
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
    @Column(name = "AreaSolicitante")
    public String getAreaSolicitante() {
        return areaSolicitante;
    }

    public void setAreaSolicitante(String areaSolicitante) {
        this.areaSolicitante = areaSolicitante;
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
    @Column(name = "RolesAreasInvolucradas")
    public String getRolesAreasInvolucradas() {
        return rolesAreasInvolucradas;
    }

    public void setRolesAreasInvolucradas(String rolesAreasInvolucradas) {
        this.rolesAreasInvolucradas = rolesAreasInvolucradas;
    }

    @Basic
    @Column(name = "RequerimientosFuncionales")
    public String getRequerimientosFuncionales() {
        return requerimientosFuncionales;
    }

    public void setRequerimientosFuncionales(String requerimientosFuncionales) {
        this.requerimientosFuncionales = requerimientosFuncionales;
    }

    @Basic
    @Column(name = "Requerimientosnofuncionales")
    public String getRequerimientosnofuncionales() {
        return requerimientosnofuncionales;
    }

    public void setRequerimientosnofuncionales(String requerimientosnofuncionales) {
        this.requerimientosnofuncionales = requerimientosnofuncionales;
    }

    @Basic
    @Column(name = "LenguajesProgramacion")
    public String getLenguajesProgramacion() {
        return lenguajesProgramacion;
    }

    public void setLenguajesProgramacion(String lenguajesProgramacion) {
        this.lenguajesProgramacion = lenguajesProgramacion;
    }

    @Basic
    @Column(name = "Frameworks")
    public String getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(String frameworks) {
        this.frameworks = frameworks;
    }

    @Basic
    @Column(name = "BasesDatos")
    public String getBasesDatos() {
        return basesDatos;
    }

    public void setBasesDatos(String basesDatos) {
        this.basesDatos = basesDatos;
    }

    @Basic
    @Column(name = "HerramientasDesarrollo")
    public String getHerramientasDesarrollo() {
        return herramientasDesarrollo;
    }

    public void setHerramientasDesarrollo(String herramientasDesarrollo) {
        this.herramientasDesarrollo = herramientasDesarrollo;
    }

    @Basic
    @Column(name = "ServidoresAplicaciones")
    public String getServidoresAplicaciones() {
        return servidoresAplicaciones;
    }

    public void setServidoresAplicaciones(String servidoresAplicaciones) {
        this.servidoresAplicaciones = servidoresAplicaciones;
    }

    @Basic
    @Column(name = "Perfil")
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Basic
    @Column(name = "TareasProyecto")
    public String getTareasProyecto() {
        return tareasProyecto;
    }

    public void setTareasProyecto(String tareasProyecto) {
        this.tareasProyecto = tareasProyecto;
    }

    @Basic
    @Column(name = "Metodologias")
    public String getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(String metodologias) {
        this.metodologias = metodologias;
    }

    @Basic
    @Column(name = "Documentacion")
    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    @Basic
    @Column(name = "FechaIngreso")
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
    @Column(name = "PuestoRHPRO")
    public String getPuestoRhpro() {
        return puestoRhpro;
    }

    public void setPuestoRhpro(String puestoRhpro) {
        this.puestoRhpro = puestoRhpro;
    }

    @Basic
    @Column(name = "CentroCosto")
    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    @Basic
    @Column(name = "PromovidoLPS")
    public String getPromovidoLps() {
        return promovidoLps;
    }

    public void setPromovidoLps(String promovidoLps) {
        this.promovidoLps = promovidoLps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseNueva baseNueva = (BaseNueva) o;
        return id == baseNueva.id &&
                Double.compare(baseNueva.legajo, legajo) == 0 &&
                Double.compare(baseNueva.añoLps, añoLps) == 0 &&
                Objects.equals(apellidos, baseNueva.apellidos) &&
                Objects.equals(nombres, baseNueva.nombres) &&
                Objects.equals(relevado, baseNueva.relevado) &&
                Objects.equals(peopleCare, baseNueva.peopleCare) &&
                Objects.equals(clienteActual, baseNueva.clienteActual) &&
                Objects.equals(domicilioLaboral, baseNueva.domicilioLaboral) &&
                Objects.equals(observacionesEmpleado, baseNueva.observacionesEmpleado) &&
                Objects.equals(nombreResponsable, baseNueva.nombreResponsable) &&
                Objects.equals(nombreProyecto, baseNueva.nombreProyecto) &&
                Objects.equals(observacionesProyecto, baseNueva.observacionesProyecto) &&
                Objects.equals(liderProyecto, baseNueva.liderProyecto) &&
                Objects.equals(objetivoProyecto, baseNueva.objetivoProyecto) &&
                Objects.equals(internoExterno, baseNueva.internoExterno) &&
                Objects.equals(equipoTrabajo, baseNueva.equipoTrabajo) &&
                Objects.equals(fechaInicio, baseNueva.fechaInicio) &&
                Objects.equals(fechaFin, baseNueva.fechaFin) &&
                Objects.equals(areaSolicitante, baseNueva.areaSolicitante) &&
                Objects.equals(usuarios, baseNueva.usuarios) &&
                Objects.equals(rolesAreasInvolucradas, baseNueva.rolesAreasInvolucradas) &&
                Objects.equals(requerimientosFuncionales, baseNueva.requerimientosFuncionales) &&
                Objects.equals(requerimientosnofuncionales, baseNueva.requerimientosnofuncionales) &&
                Objects.equals(lenguajesProgramacion, baseNueva.lenguajesProgramacion) &&
                Objects.equals(frameworks, baseNueva.frameworks) &&
                Objects.equals(basesDatos, baseNueva.basesDatos) &&
                Objects.equals(herramientasDesarrollo, baseNueva.herramientasDesarrollo) &&
                Objects.equals(servidoresAplicaciones, baseNueva.servidoresAplicaciones) &&
                Objects.equals(perfil, baseNueva.perfil) &&
                Objects.equals(tareasProyecto, baseNueva.tareasProyecto) &&
                Objects.equals(metodologias, baseNueva.metodologias) &&
                Objects.equals(documentacion, baseNueva.documentacion) &&
                Objects.equals(fechaIngreso, baseNueva.fechaIngreso) &&
                Objects.equals(fechaEgreso, baseNueva.fechaEgreso) &&
                Objects.equals(puestoRhpro, baseNueva.puestoRhpro) &&
                Objects.equals(centroCosto, baseNueva.centroCosto) &&
                Objects.equals(promovidoLps, baseNueva.promovidoLps);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legajo, apellidos, nombres, relevado, añoLps, peopleCare, clienteActual, domicilioLaboral, observacionesEmpleado, nombreResponsable, nombreProyecto, observacionesProyecto, liderProyecto, objetivoProyecto, internoExterno, equipoTrabajo, fechaInicio, fechaFin, areaSolicitante, usuarios, rolesAreasInvolucradas, requerimientosFuncionales, requerimientosnofuncionales, lenguajesProgramacion, frameworks, basesDatos, herramientasDesarrollo, servidoresAplicaciones, perfil, tareasProyecto, metodologias, documentacion, fechaIngreso, fechaEgreso, puestoRhpro, centroCosto, promovidoLps);
    }
}
