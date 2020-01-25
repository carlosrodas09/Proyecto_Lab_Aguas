package com.mycompany.employee;

import com.mycompany.packageLab.Analysis;
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
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dpi_employee")
    private String dpiEmployee;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "name_employee")
    private String nameEmployee;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "phone_employee")
    private String phoneEmployee;
    @JoinColumn(name = "staff_position_id", referencedColumnName = "id_staff_position")
    @ManyToOne(optional = false)
    private StaffPosition staffPositionId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employeeDpi")
    private List<Analysis> analysisList;

    public Employee() {
    }

    public Employee(String dpiEmployee) {
        this.dpiEmployee = dpiEmployee;
    }

    public Employee(String dpiEmployee, String password, String nameEmployee, boolean isActive) {
        this.dpiEmployee = dpiEmployee;
        this.password = password;
        this.nameEmployee = nameEmployee;
        this.isActive = isActive;
    }

    public Employee(String dpiEmployee, String password, String nameEmployee, boolean isActive, String phoneEmployee, StaffPosition staffPositionId, List<Analysis> analysisList) {
        this.dpiEmployee = dpiEmployee;
        this.password = password;
        this.nameEmployee = nameEmployee;
        this.isActive = isActive;
        this.phoneEmployee = phoneEmployee;
        this.staffPositionId = staffPositionId;
        this.analysisList = analysisList;
    }

    public String getDpiEmployee() {
        return dpiEmployee;
    }

    public void setDpiEmployee(String dpiEmployee) {
        this.dpiEmployee = dpiEmployee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public StaffPosition getStaffPositionId() {
        return staffPositionId;
    }

    public void setStaffPositionId(StaffPosition staffPositionId) {
        this.staffPositionId = staffPositionId;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDpiEmployee());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        return Objects.equals(getDpiEmployee(), other.getDpiEmployee());
    }

}
