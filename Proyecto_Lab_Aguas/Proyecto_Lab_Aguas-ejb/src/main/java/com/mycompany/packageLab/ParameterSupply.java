package com.mycompany.packageLab;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.mycompany.supply.Supply;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "PARAMETER_SUPPLY")
public class ParameterSupply implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_parameter_supply")
    private Integer idParameterSupply;
    @Basic(optional = false)
    @Column(name = "amount_used")
    private double amountUsed;
    @JoinColumn(name = "parameter_id", referencedColumnName = "id_parameter")
    @ManyToOne(optional = false)
    private Parameter parameterId;
    @JoinColumn(name = "supply_id", referencedColumnName = "id_supply")
    @ManyToOne(optional = false)
    private Supply supplyId;

    public ParameterSupply() {
    }

    public ParameterSupply(Integer idParameterSupply) {
        this.idParameterSupply = idParameterSupply;
    }

    public ParameterSupply(Integer idParameterSupply, double amountUsed) {
        this.idParameterSupply = idParameterSupply;
        this.amountUsed = amountUsed;
    }

    public ParameterSupply(Integer idParameterSupply, double amountUsed, Parameter parameterId, Supply supplyId) {
        this.idParameterSupply = idParameterSupply;
        this.amountUsed = amountUsed;
        this.parameterId = parameterId;
        this.supplyId = supplyId;
    }

    public Integer getIdParameterSupply() {
        return idParameterSupply;
    }

    public void setIdParameterSupply(Integer idParameterSupply) {
        this.idParameterSupply = idParameterSupply;
    }

    public double getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(double amountUsed) {
        this.amountUsed = amountUsed;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }

    public Supply getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Supply supplyId) {
        this.supplyId = supplyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdParameterSupply());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ParameterSupply)) {
            return false;
        }
        ParameterSupply other = (ParameterSupply) object;
        return Objects.equals(getIdParameterSupply(), other.getIdParameterSupply());
    }

    @Override
    public String toString() {
        return "lab.aguas.entity.ParameterSupply[ idParameterSupply=" + idParameterSupply + " ]";
    }
    
}
