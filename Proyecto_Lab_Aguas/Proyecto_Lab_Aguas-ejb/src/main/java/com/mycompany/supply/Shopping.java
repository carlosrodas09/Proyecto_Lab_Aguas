package com.mycompany.supply;

import java.io.Serializable;
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
@Table(name = "SHOPPING")
public class Shopping implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_shopping")
    private Integer idShopping;
    @Basic(optional = false)
    @Column(name = "amount_purchased")
    private double amountPurchased;
    @Basic(optional = false)
    @Column(name = "date_shopping")
    @Temporal(TemporalType.DATE)
    private Date dateShopping;
    @Column(name = "note_shopping")
    private String noteShopping;
    @JoinColumn(name = "equipment_id", referencedColumnName = "id_equipment")
    @ManyToOne
    private Equipment equipmentId;
    @JoinColumn(name = "provider_id", referencedColumnName = "id_provider")
    @ManyToOne(optional = false)
    private Provider providerId;
    @JoinColumn(name = "supply_id", referencedColumnName = "id_supply")
    @ManyToOne
    private Supply supplyId;

    public Shopping() {
    }

    public Shopping(Integer idShopping) {
        this.idShopping = idShopping;
    }

    public Shopping(Integer idShopping, double amountPurchased, Date dateShopping) {
        this.idShopping = idShopping;
        this.amountPurchased = amountPurchased;
        this.dateShopping = dateShopping;
    }

    public Shopping(Integer idShopping, double amountPurchased, Date dateShopping, String noteShopping, Equipment equipmentId, Provider providerId, Supply supplyId) {
        this.idShopping = idShopping;
        this.amountPurchased = amountPurchased;
        this.dateShopping = dateShopping;
        this.noteShopping = noteShopping;
        this.equipmentId = equipmentId;
        this.providerId = providerId;
        this.supplyId = supplyId;
    }

    public Integer getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(Integer idShopping) {
        this.idShopping = idShopping;
    }

    public double getAmountPurchased() {
        return amountPurchased;
    }

    public void setAmountPurchased(double amountPurchased) {
        this.amountPurchased = amountPurchased;
    }

    public Date getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(Date dateShopping) {
        this.dateShopping = dateShopping;
    }

    public String getNoteShopping() {
        return noteShopping;
    }

    public void setNoteShopping(String noteShopping) {
        this.noteShopping = noteShopping;
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

    public Supply getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Supply supplyId) {
        this.supplyId = supplyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdShopping());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Shopping)) {
            return false;
        }
        Shopping other = (Shopping) object;
        return Objects.equals(getIdShopping(), other.getIdShopping());
    }

}
