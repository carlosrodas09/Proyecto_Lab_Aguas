package com.mycompany.supply;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "PROVIDER")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_provider")
    private Integer idProvider;
    @Basic(optional = false)
    @Column(name = "nit_provider")
    private String nitProvider;
    @Basic(optional = false)
    @Column(name = "name_provider")
    private String nameProvider;
    @Basic(optional = false)
    @Column(name = "phone_provider")
    private String phoneProvider;
    @Column(name = "direction_provider")
    private String directionProvider;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "providerId")
    private List<Maintenance> maintenanceList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "providerId")
    private List<Shopping> shoppingList;

    public Provider() {
    }

    public Provider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public Provider(Integer idProvider, String nitProvider, String nameProvider, String phoneProvider) {
        this.idProvider = idProvider;
        this.nitProvider = nitProvider;
        this.nameProvider = nameProvider;
        this.phoneProvider = phoneProvider;
    }

    public Provider(Integer idProvider, String nitProvider, String nameProvider, String phoneProvider, String directionProvider, List<Maintenance> maintenanceList, List<Shopping> shoppingList) {
        this.idProvider = idProvider;
        this.nitProvider = nitProvider;
        this.nameProvider = nameProvider;
        this.phoneProvider = phoneProvider;
        this.directionProvider = directionProvider;
        this.maintenanceList = maintenanceList;
        this.shoppingList = shoppingList;
    }

    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public String getNitProvider() {
        return nitProvider;
    }

    public void setNitProvider(String nitProvider) {
        this.nitProvider = nitProvider;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public String getPhoneProvider() {
        return phoneProvider;
    }

    public void setPhoneProvider(String phoneProvider) {
        this.phoneProvider = phoneProvider;
    }

    public String getDirectionProvider() {
        return directionProvider;
    }

    public void setDirectionProvider(String directionProvider) {
        this.directionProvider = directionProvider;
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

    @Override
    public int hashCode() {
        return Objects.hash(getIdProvider());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        return Objects.equals(getIdProvider(), other.getIdProvider());
    }
    
}
