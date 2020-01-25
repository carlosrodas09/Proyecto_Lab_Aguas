package com.mycompany.sample;

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
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_department")
    private Integer idDepartment;
    @Basic(optional = false)
    @Column(name = "name_department")
    private String nameDepartment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private List<Municipality> municipalityList;

    public Department() {
    }

    public Department(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Department(Integer idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public List<Municipality> getMunicipalityList() {
        return municipalityList;
    }

    public void setMunicipalityList(List<Municipality> municipalityList) {
        this.municipalityList = municipalityList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDepartment());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        return Objects.equals(getIdDepartment(), other.getIdDepartment());
    }
    
}
