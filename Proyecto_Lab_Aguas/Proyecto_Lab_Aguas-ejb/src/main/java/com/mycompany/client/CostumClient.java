package com.mycompany.client;

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
@Table(name = "COSTUM_CLIENT")
public class CostumClient implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_costum_category")
    private Integer idCostumCategory;
    @Basic(optional = false)
    @Column(name = "name_costum_category")
    private String nameCostumCategory;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "costumClientId")
    private List<Client> clientList;

    public CostumClient() {
    }

    public CostumClient(Integer idCostumCategory) {
        this.idCostumCategory = idCostumCategory;
    }

    public CostumClient(Integer idCostumCategory, String nameCostumCategory) {
        this.idCostumCategory = idCostumCategory;
        this.nameCostumCategory = nameCostumCategory;
    }

    public CostumClient(Integer idCostumCategory, String nameCostumCategory, String description, List<Client> clientList) {
        this.idCostumCategory = idCostumCategory;
        this.nameCostumCategory = nameCostumCategory;
        this.description = description;
        this.clientList = clientList;
    }

    public Integer getIdCostumCategory() {
        return idCostumCategory;
    }

    public void setIdCostumCategory(Integer idCostumCategory) {
        this.idCostumCategory = idCostumCategory;
    }

    public String getNameCostumCategory() {
        return nameCostumCategory;
    }

    public void setNameCostumCategory(String nameCostumCategory) {
        this.nameCostumCategory = nameCostumCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCostumCategory());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CostumClient)) {
            return false;
        }
        CostumClient cc = (CostumClient) object;
        return Objects.equals(getIdCostumCategory(), cc.getIdCostumCategory());
    }

}
