package com.mycompany.supply;

import com.mycompany.packageLab.ParameterEquipment;
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
@Table(name = "EQUIPMENT")
public class Equipment implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_equipment")
    private Integer idEquipment;
    @Basic(optional = false)
    @Column(name = "name_equipment")
    private String nameEquipment;
    @Basic(optional = false)
    @Column(name = "model_equipment")
    private String modelEquipment;
    @Basic(optional = false)
    @Column(name = "working_hours")
    private int workingHours;
    @Basic(optional = false)
    @Column(name = "maintenance_time")
    private int maintenanceTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private List<Maintenance> maintenanceList;
    @OneToMany(mappedBy = "equipmentId")
    private List<Shopping> shoppingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentId")
    private List<ParameterEquipment> parameterEquipmentList;

    public Equipment() {
    }

    public Equipment(Integer idEquipment) {
        this.idEquipment = idEquipment;
    }

    public Equipment(Integer idEquipment, String nameEquipment, String modelEquipment, int workingHours, int maintenanceTime) {
        this.idEquipment = idEquipment;
        this.nameEquipment = nameEquipment;
        this.modelEquipment = modelEquipment;
        this.workingHours = workingHours;
        this.maintenanceTime = maintenanceTime;
    }

    public Equipment(Integer idEquipment, String nameEquipment, String modelEquipment, int workingHours, int maintenanceTime, List<Maintenance> maintenanceList, List<Shopping> shoppingList, List<ParameterEquipment> parameterEquipmentList) {
        this.idEquipment = idEquipment;
        this.nameEquipment = nameEquipment;
        this.modelEquipment = modelEquipment;
        this.workingHours = workingHours;
        this.maintenanceTime = maintenanceTime;
        this.maintenanceList = maintenanceList;
        this.shoppingList = shoppingList;
        this.parameterEquipmentList = parameterEquipmentList;
    }

    public Integer getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(Integer idEquipment) {
        this.idEquipment = idEquipment;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public String getModelEquipment() {
        return modelEquipment;
    }

    public void setModelEquipment(String modelEquipment) {
        this.modelEquipment = modelEquipment;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(int maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public void setMaintenanceList(List<Maintenance> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<ParameterEquipment> getParameterEquipmentList() {
        return parameterEquipmentList;
    }

    public void setParameterEquipmentList(List<ParameterEquipment> parameterEquipmentList) {
        this.parameterEquipmentList = parameterEquipmentList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEquipment());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        return Objects.equals(getIdEquipment(), other.getIdEquipment());
    }

}
