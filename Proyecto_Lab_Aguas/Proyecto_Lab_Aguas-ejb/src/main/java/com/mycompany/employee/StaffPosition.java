package com.mycompany.employee;

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
@Table(name = "STAFF_POSITION")
public class StaffPosition implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_staff_position")
    private Integer idStaffPosition;
    @Basic(optional = false)
    @Column(name = "name_staff_position")
    private String nameStaffPosition;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "staffPositionId")
    private List<Employee> employeeList;

    public StaffPosition() {
    }

    public StaffPosition(Integer idStaffPosition) {
        this.idStaffPosition = idStaffPosition;
    }

    public StaffPosition(Integer idStaffPosition, String nameStaffPosition) {
        this.idStaffPosition = idStaffPosition;
        this.nameStaffPosition = nameStaffPosition;
    }

    public StaffPosition(Integer idStaffPosition, String nameStaffPosition, List<Employee> employeeList) {
        this.idStaffPosition = idStaffPosition;
        this.nameStaffPosition = nameStaffPosition;
        this.employeeList = employeeList;
    }

    public Integer getIdStaffPosition() {
        return idStaffPosition;
    }

    public void setIdStaffPosition(Integer idStaffPosition) {
        this.idStaffPosition = idStaffPosition;
    }

    public String getNameStaffPosition() {
        return nameStaffPosition;
    }

    public void setNameStaffPosition(String nameStaffPosition) {
        this.nameStaffPosition = nameStaffPosition;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdStaffPosition());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof StaffPosition)) {
            return false;
        }
        StaffPosition other = (StaffPosition) object;
        return Objects.equals(getIdStaffPosition(), other.getIdStaffPosition());

    }

}
