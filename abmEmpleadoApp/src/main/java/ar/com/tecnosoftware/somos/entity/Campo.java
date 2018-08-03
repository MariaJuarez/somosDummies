package ar.com.tecnosoftware.somos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Campo {
    private int idCampo;
    private String descCampo;
    private String tooltipCampo;

    @Id
    @Column(name = "IdCampo")
    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    @Basic
    @Column(name = "DescCampo")
    public String getDescCampo() {
        return descCampo;
    }

    public void setDescCampo(String descCampo) {
        this.descCampo = descCampo;
    }

    @Basic
    @Column(name = "TooltipCampo")
    public String getTooltipCampo() {
        return tooltipCampo;
    }

    public void setTooltipCampo(String tooltipCampo) {
        this.tooltipCampo = tooltipCampo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campo campo = (Campo) o;
        return idCampo == campo.idCampo &&
                Objects.equals(descCampo, campo.descCampo) &&
                Objects.equals(tooltipCampo, campo.tooltipCampo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCampo, descCampo, tooltipCampo);
    }
}
