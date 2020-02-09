package com.mycompany.supply;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "MAINTENANCE")
public class Maintenance implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_maintenance")
    private Integer idMaintenance;
    @Basic(optional = false)
    @Column(name = "maintenance_date")
    @Temporal(TemporalType.DATE)
    private LocalDate maintenanceDate;
    @Basic(optional = false)
    @Column(name = "maintenance_cost")
    private Double maintenanceCost;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id_equipment")
    @ManyToOne(optional = false)
    private Equipment equipmentId;
    @JoinColumn(name = "provider_id", referencedColumnName = "id_provider")
    @ManyToOne(optional = false)
    private Provider providerId;

    public Maintenance() {
    }

    public Maintenance(Integer idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public Maintenance(Integer idMaintenance, LocalDate maintenanceDate, Double maintenanceCost) {
        this.idMaintenance = idMaintenance;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceCost = maintenanceCost;
    }

    public Maintenance(Integer idMaintenance, LocalDate maintenanceDate, Double maintenanceCost, Equipment equipmentId, Provider providerId) {
        this.idMaintenance = idMaintenance;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceCost = maintenanceCost;
        this.equipmentId = equipmentId;
        this.providerId = providerId;
    }

    public Integer getIdMaintenance() {
        return idMaintenance;
    }

    public void setIdMaintenance(Integer idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMaintenance());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Maintenance)) {
            return false;
        }
        Maintenance other = (Maintenance) object;
        return Objects.equals(getIdMaintenance(), other.getIdMaintenance());
    }
}
