package com.mycompany.sample;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "MUNICIPALITY")
public class Municipality implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_municipality")
    private Integer idMunicipality;
    @Basic(optional = false)
    @Column(name = "name_municipality")
    private String nameMunicipality;
    @JoinColumn(name = "department_id", referencedColumnName = "id_department")
    @ManyToOne(optional = false)
    private Department departmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipalityId")
    private List<Sample> sampleList;

    public Municipality() {
    }

    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public String getNameMunicipality() {
        return nameMunicipality;
    }

    public void setNameMunicipality(String nameMunicipality) {
        this.nameMunicipality = nameMunicipality;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMunicipality());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Municipality)) {
            return false;
        }
        Municipality other = (Municipality) object;
        return Objects.equals(getIdMunicipality(), other.getIdMunicipality());
    }

}
