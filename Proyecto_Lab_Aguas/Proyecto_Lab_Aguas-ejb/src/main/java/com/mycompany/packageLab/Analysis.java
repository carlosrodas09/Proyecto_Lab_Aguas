package com.mycompany.packageLab;

import com.mycompany.sample.Sample;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.mycompany.employee.Employee;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "ANALYSIS")
public class Analysis implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_analysis")
    private Integer idAnalysis;
    @Basic(optional = false)
    @Column(name = "date_analysis")
    @Temporal(TemporalType.DATE)
    private Date dateAnalysis;
    @Basic(optional = false)
    @Column(name = "cost_analysis")
    private double costAnalysis;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "analysisId")
    private List<AnalysisPackage> analysisPackageList;
    @JoinColumn(name = "employee_dpi", referencedColumnName = "dpi_employee")
    @ManyToOne(optional = false)
    private Employee employeeDpi;
    @JoinColumn(name = "sample_id", referencedColumnName = "id_sample")
    @ManyToOne(optional = false)
    private Sample sampleId;

    public Analysis() {
    }

    public Analysis(Integer idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public Analysis(Integer idAnalysis, Date dateAnalysis, double costAnalysis) {
        this.idAnalysis = idAnalysis;
        this.dateAnalysis = dateAnalysis;
        this.costAnalysis = costAnalysis;
    }

    public Analysis(Integer idAnalysis, Date dateAnalysis, double costAnalysis, Employee employeeDpi, Sample sampleId) {
        this.idAnalysis = idAnalysis;
        this.dateAnalysis = dateAnalysis;
        this.costAnalysis = costAnalysis;
        this.employeeDpi = employeeDpi;
        this.sampleId = sampleId;
    }

    public Integer getIdAnalysis() {
        return idAnalysis;
    }

    public void setIdAnalysis(Integer idAnalysis) {
        this.idAnalysis = idAnalysis;
    }

    public Date getDateAnalysis() {
        return dateAnalysis;
    }

    public void setDateAnalysis(Date dateAnalysis) {
        this.dateAnalysis = dateAnalysis;
    }

    public double getCostAnalysis() {
        return costAnalysis;
    }

    public void setCostAnalysis(double costAnalysis) {
        this.costAnalysis = costAnalysis;
    }

    public List<AnalysisPackage> getAnalysisPackageList() {
        return analysisPackageList;
    }

    public void setAnalysisPackageList(List<AnalysisPackage> analysisPackageList) {
        this.analysisPackageList = analysisPackageList;
    }

    public Employee getEmployeeDpi() {
        return employeeDpi;
    }

    public void setEmployeeDpi(Employee employeeDpi) {
        this.employeeDpi = employeeDpi;
    }

    public Sample getSampleId() {
        return sampleId;
    }

    public void setSampleId(Sample sampleId) {
        this.sampleId = sampleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAnalysis());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Analysis)) {
            return false;
        }
        Analysis other = (Analysis) object;
        return Objects.equals(getIdAnalysis(), other.getIdAnalysis());
    }

}
