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
import com.mycompany.supply.Equipment;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "PARAMETER_EQUIPMENT")
public class ParameterEquipment implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_parameter_equipment")
    private Integer idParameterEquipment;
    @Basic(optional = false)
    @Column(name = "working_hours")
    private double workingHours;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id_equipment")
    @ManyToOne(optional = false)
    private Equipment equipmentId;
    @JoinColumn(name = "parameter_id", referencedColumnName = "id_parameter")
    @ManyToOne(optional = false)
    private Parameter parameterId;

    public ParameterEquipment() {
    }

    public ParameterEquipment(Integer idParameterEquipment) {
        this.idParameterEquipment = idParameterEquipment;
    }

    public ParameterEquipment(Integer idParameterEquipment, double workingHours) {
        this.idParameterEquipment = idParameterEquipment;
        this.workingHours = workingHours;
    }

    public ParameterEquipment(Integer idParameterEquipment, double workingHours, Equipment equipmentId, Parameter parameterId) {
        this.idParameterEquipment = idParameterEquipment;
        this.workingHours = workingHours;
        this.equipmentId = equipmentId;
        this.parameterId = parameterId;
    }

    public Integer getIdParameterEquipment() {
        return idParameterEquipment;
    }

    public void setIdParameterEquipment(Integer idParameterEquipment) {
        this.idParameterEquipment = idParameterEquipment;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdParameterEquipment());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ParameterEquipment)) {
            return false;
        }
        ParameterEquipment other = (ParameterEquipment) object;
        return Objects.equals(getIdParameterEquipment(), other.getIdParameterEquipment());
    }
    
}
