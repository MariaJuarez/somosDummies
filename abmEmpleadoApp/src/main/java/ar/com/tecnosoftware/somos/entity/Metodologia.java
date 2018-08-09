package ar.com.tecnosoftware.somos.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Metodologia implements Serializable {
    private int idMetodologia;
    private String descMetodologia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMetodologia")
    public int getIdMetodologia() {
        return idMetodologia;
    }

    public void setIdMetodologia(int idMetodologia) {
        this.idMetodologia = idMetodologia;
    }

    @Basic
    @Column(name = "DescMetodologia")
    public String getDescMetodologia() {
        return descMetodologia;
    }

    public void setDescMetodologia(String descMetodologia) {
        this.descMetodologia = descMetodologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metodologia that = (Metodologia) o;
        return idMetodologia == that.idMetodologia &&
                Objects.equals(descMetodologia, that.descMetodologia);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMetodologia, descMetodologia);
    }

}
