package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Rubro {
    private int idRubro;
    private String descRubro;
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRubro")
    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    @Basic
    @Column(name = "DescRubro")
    public String getDescRubro() {
        return descRubro;
    }

    public void setDescRubro(String descRubro) {
        this.descRubro = descRubro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rubro rubro = (Rubro) o;
        return idRubro == rubro.idRubro &&
                Objects.equals(descRubro, rubro.descRubro);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRubro, descRubro);
    }

    @OneToOne(mappedBy = "rubro")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
