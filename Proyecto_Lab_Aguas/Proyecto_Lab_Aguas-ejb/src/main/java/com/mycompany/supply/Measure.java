package com.mycompany.supply;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "MEASURE")
public class Measure implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_measure")
    private Integer idMeasure;
    @Basic(optional = false)
    @Column(name = "name_measure")
    private String nameMeasure;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measureId")
    private List<Supply> supplyList;

    public Measure() {
    }

    public Measure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }

    public Measure(Integer idMeasure, String nameMeasure) {
        this.idMeasure = idMeasure;
        this.nameMeasure = nameMeasure;
    }

    public Integer getIdMeasure() {
        return idMeasure;
    }

    public void setIdMeasure(Integer idMeasure) {
        this.idMeasure = idMeasure;
    }

    public String getNameMeasure() {
        return nameMeasure;
    }

    public void setNameMeasure(String nameMeasure) {
        this.nameMeasure = nameMeasure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Supply> getSupplyList() {
        return supplyList;
    }

    public void setSupplyList(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMeasure());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Measure)) {
            return false;
        }
        Measure other = (Measure) object;
        return Objects.equals(getIdMeasure(), other.getIdMeasure());
    }

}
