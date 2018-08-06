package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Base {
    private int id;
    private double legajo;
    private String apellidos;
    private String nombres;
    private Date relevado;
    private double añoLps;
    private String peopleCare;
    private String clienteActual;
    private String domicilioLaboral;
    private String nombreResponsableDirecto;
    private Date responsableContactado;
    private String nombreProyecto;
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
    private String requerimientosNoFuncionales;
    private String lenguajeProgramacion;
    private String frameworks;
    private String baseDatos;
    private String herramientasDesarrollo;
    private String servidoresAplicaciones;
    private String perfil;
    private String tareasProyecto;
    private String metodologias;
    private String documentación;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private String puestoRhpro;
    private String citable;
    private String centroCosto;
    private String okReferente;
    private String referencias;
    private String observaciones;
    private String numeroOportunidad;
    private String nombrePropEconomica;
    private String nombrePropTecnica;
    private String promovidoLps;
    private String proyectoPresentado2013;
    private String puestoPresentado2013;
    private Date fechaInicioProyectoPresentado2013;
    private Date fechaFinalProyectoPresentado2013;
    private Date clientePresentado2013;
    private String detalleObservacionesPresentado2013;

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
    @Column(name = "NombreResponsableDirecto")
    public String getNombreResponsableDirecto() {
        return nombreResponsableDirecto;
    }

    public void setNombreResponsableDirecto(String nombreResponsableDirecto) {
        this.nombreResponsableDirecto = nombreResponsableDirecto;
    }

    @Basic
    @Column(name = "ResponsableContactado")
    public Date getResponsableContactado() {
        return responsableContactado;
    }

    public void setResponsableContactado(Date responsableContactado) {
        this.responsableContactado = responsableContactado;
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
    @Column(name = "[RequerimientosNoFuncionales")
    public String getRequerimientosNoFuncionales() {
        return requerimientosNoFuncionales;
    }

    public void setRequerimientosNoFuncionales(String requerimientosNoFuncionales) {
        this.requerimientosNoFuncionales = requerimientosNoFuncionales;
    }

    @Basic
    @Column(name = "LenguajeProgramacion")
    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
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
    @Column(name = "BaseDatos")
    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
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
    @Column(name = "Documentación")
    public String getDocumentación() {
        return documentación;
    }

    public void setDocumentación(String documentación) {
        this.documentación = documentación;
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
    @Column(name = "Citable")
    public String getCitable() {
        return citable;
    }

    public void setCitable(String citable) {
        this.citable = citable;
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
    @Column(name = "OkReferente")
    public String getOkReferente() {
        return okReferente;
    }

    public void setOkReferente(String okReferente) {
        this.okReferente = okReferente;
    }

    @Basic
    @Column(name = "Referencias")
    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
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
    @Column(name = "NumeroOportunidad")
    public String getNumeroOportunidad() {
        return numeroOportunidad;
    }

    public void setNumeroOportunidad(String numeroOportunidad) {
        this.numeroOportunidad = numeroOportunidad;
    }

    @Basic
    @Column(name = "NombrePropEconomica")
    public String getNombrePropEconomica() {
        return nombrePropEconomica;
    }

    public void setNombrePropEconomica(String nombrePropEconomica) {
        this.nombrePropEconomica = nombrePropEconomica;
    }

    @Basic
    @Column(name = "NombrePropTecnica")
    public String getNombrePropTecnica() {
        return nombrePropTecnica;
    }

    public void setNombrePropTecnica(String nombrePropTecnica) {
        this.nombrePropTecnica = nombrePropTecnica;
    }

    @Basic
    @Column(name = "PromovidoLPS")
    public String getPromovidoLps() {
        return promovidoLps;
    }

    public void setPromovidoLps(String promovidoLps) {
        this.promovidoLps = promovidoLps;
    }

    @Basic
    @Column(name = "ProyectoPresentado2013")
    public String getProyectoPresentado2013() {
        return proyectoPresentado2013;
    }

    public void setProyectoPresentado2013(String proyectoPresentado2013) {
        this.proyectoPresentado2013 = proyectoPresentado2013;
    }

    @Basic
    @Column(name = "PuestoPresentado2013")
    public String getPuestoPresentado2013() {
        return puestoPresentado2013;
    }

    public void setPuestoPresentado2013(String puestoPresentado2013) {
        this.puestoPresentado2013 = puestoPresentado2013;
    }

    @Basic
    @Column(name = "FechaInicioProyectoPresentado2013")
    public Date getFechaInicioProyectoPresentado2013() {
        return fechaInicioProyectoPresentado2013;
    }

    public void setFechaInicioProyectoPresentado2013(Date fechaInicioProyectoPresentado2013) {
        this.fechaInicioProyectoPresentado2013 = fechaInicioProyectoPresentado2013;
    }

    @Basic
    @Column(name = "FechaFinalProyectoPresentado2013")
    public Date getFechaFinalProyectoPresentado2013() {
        return fechaFinalProyectoPresentado2013;
    }

    public void setFechaFinalProyectoPresentado2013(Date fechaFinalProyectoPresentado2013) {
        this.fechaFinalProyectoPresentado2013 = fechaFinalProyectoPresentado2013;
    }

    @Basic
    @Column(name = "ClientePresentado2013")
    public Date getClientePresentado2013() {
        return clientePresentado2013;
    }

    public void setClientePresentado2013(Date clientePresentado2013) {
        this.clientePresentado2013 = clientePresentado2013;
    }

    @Basic
    @Column(name = "DetalleObservacionesPresentado2013")
    public String getDetalleObservacionesPresentado2013() {
        return detalleObservacionesPresentado2013;
    }

    public void setDetalleObservacionesPresentado2013(String detalleObservacionesPresentado2013) {
        this.detalleObservacionesPresentado2013 = detalleObservacionesPresentado2013;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return id == base.id &&
                Double.compare(base.legajo, legajo) == 0 &&
                Double.compare(base.añoLps, añoLps) == 0 &&
                Objects.equals(apellidos, base.apellidos) &&
                Objects.equals(nombres, base.nombres) &&
                Objects.equals(relevado, base.relevado) &&
                Objects.equals(peopleCare, base.peopleCare) &&
                Objects.equals(clienteActual, base.clienteActual) &&
                Objects.equals(domicilioLaboral, base.domicilioLaboral) &&
                Objects.equals(nombreResponsableDirecto, base.nombreResponsableDirecto) &&
                Objects.equals(responsableContactado, base.responsableContactado) &&
                Objects.equals(nombreProyecto, base.nombreProyecto) &&
                Objects.equals(liderProyecto, base.liderProyecto) &&
                Objects.equals(objetivoProyecto, base.objetivoProyecto) &&
                Objects.equals(internoExterno, base.internoExterno) &&
                Objects.equals(equipoTrabajo, base.equipoTrabajo) &&
                Objects.equals(fechaInicio, base.fechaInicio) &&
                Objects.equals(fechaFin, base.fechaFin) &&
                Objects.equals(areaSolicitante, base.areaSolicitante) &&
                Objects.equals(usuarios, base.usuarios) &&
                Objects.equals(rolesAreasInvolucradas, base.rolesAreasInvolucradas) &&
                Objects.equals(requerimientosFuncionales, base.requerimientosFuncionales) &&
                Objects.equals(requerimientosNoFuncionales, base.requerimientosNoFuncionales) &&
                Objects.equals(lenguajeProgramacion, base.lenguajeProgramacion) &&
                Objects.equals(frameworks, base.frameworks) &&
                Objects.equals(baseDatos, base.baseDatos) &&
                Objects.equals(herramientasDesarrollo, base.herramientasDesarrollo) &&
                Objects.equals(servidoresAplicaciones, base.servidoresAplicaciones) &&
                Objects.equals(perfil, base.perfil) &&
                Objects.equals(tareasProyecto, base.tareasProyecto) &&
                Objects.equals(metodologias, base.metodologias) &&
                Objects.equals(documentación, base.documentación) &&
                Objects.equals(fechaIngreso, base.fechaIngreso) &&
                Objects.equals(fechaEgreso, base.fechaEgreso) &&
                Objects.equals(puestoRhpro, base.puestoRhpro) &&
                Objects.equals(citable, base.citable) &&
                Objects.equals(centroCosto, base.centroCosto) &&
                Objects.equals(okReferente, base.okReferente) &&
                Objects.equals(referencias, base.referencias) &&
                Objects.equals(observaciones, base.observaciones) &&
                Objects.equals(numeroOportunidad, base.numeroOportunidad) &&
                Objects.equals(nombrePropEconomica, base.nombrePropEconomica) &&
                Objects.equals(nombrePropTecnica, base.nombrePropTecnica) &&
                Objects.equals(promovidoLps, base.promovidoLps) &&
                Objects.equals(proyectoPresentado2013, base.proyectoPresentado2013) &&
                Objects.equals(puestoPresentado2013, base.puestoPresentado2013) &&
                Objects.equals(fechaInicioProyectoPresentado2013, base.fechaInicioProyectoPresentado2013) &&
                Objects.equals(fechaFinalProyectoPresentado2013, base.fechaFinalProyectoPresentado2013) &&
                Objects.equals(clientePresentado2013, base.clientePresentado2013) &&
                Objects.equals(detalleObservacionesPresentado2013, base.detalleObservacionesPresentado2013);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legajo, apellidos, nombres, relevado, añoLps, peopleCare, clienteActual, domicilioLaboral, nombreResponsableDirecto, responsableContactado, nombreProyecto, liderProyecto, objetivoProyecto, internoExterno, equipoTrabajo, fechaInicio, fechaFin, areaSolicitante, usuarios, rolesAreasInvolucradas, requerimientosFuncionales, requerimientosNoFuncionales, lenguajeProgramacion, frameworks, baseDatos, herramientasDesarrollo, servidoresAplicaciones, perfil, tareasProyecto, metodologias, documentación, fechaIngreso, fechaEgreso, puestoRhpro, citable, centroCosto, okReferente, referencias, observaciones, numeroOportunidad, nombrePropEconomica, nombrePropTecnica, promovidoLps, proyectoPresentado2013, puestoPresentado2013, fechaInicioProyectoPresentado2013, fechaFinalProyectoPresentado2013, clientePresentado2013, detalleObservacionesPresentado2013);
    }
}
