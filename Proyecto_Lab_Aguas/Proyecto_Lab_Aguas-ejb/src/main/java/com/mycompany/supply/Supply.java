package com.mycompany.supply;

import com.mycompany.packageLab.ParameterSupply;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "SUPPLY")
public class Supply implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_supply")
    private Integer idSupply;
    @Basic(optional = false)
    @Column(name = "name_supply")
    private String nameSupply;
    @Basic(optional = false)
    @Column(name = "date_expiry")
    private LocalDate dateExpiry;
    @Basic(optional = false)
    @Column(name = "quantity_available")
    private Double quantityAvailable;
    @Lob
    @Column(name = "security_sheet")
    private byte[] securitySheet;
    @OneToMany(mappedBy = "supplyId")
    private List<Shopping> shoppingList;
    @JoinColumn(name = "measure_id", referencedColumnName = "id_measure")
    @ManyToOne(optional = false)
    private Measure measureId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplyId")
    private List<ParameterSupply> parameterSupplyList;

    public Supply() {
    }

    public Supply(Integer idSupply) {
        this.idSupply = idSupply;
    }

    public Supply(Integer idSupply, String nameSupply, LocalDate dateExpiry, double quantityAvailable) {
        this.idSupply = idSupply;
        this.nameSupply = nameSupply;
        this.dateExpiry = dateExpiry;
        this.quantityAvailable = quantityAvailable;
    }

    public Integer getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(Integer idSupply) {
        this.idSupply = idSupply;
    }

    public String getNameSupply() {
        return nameSupply;
    }

    public void setNameSupply(String nameSupply) {
        this.nameSupply = nameSupply;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDate dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public Double getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Double quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public byte[] getSecuritySheet() {
        return securitySheet;
    }

    public void setSecuritySheet(byte[] securitySheet) {
        this.securitySheet = securitySheet;
    }

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Measure getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Measure measureId) {
        this.measureId = measureId;
    }

    public List<ParameterSupply> getParameterSupplyList() {
        return parameterSupplyList;
    }

    public void setParameterSupplyList(List<ParameterSupply> parameterSupplyList) {
        this.parameterSupplyList = parameterSupplyList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSupply());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Supply)) {
            return false;
        }
        Supply other = (Supply) object;
        return Objects.equals(getIdSupply(), other.getIdSupply());
    }
    
}
