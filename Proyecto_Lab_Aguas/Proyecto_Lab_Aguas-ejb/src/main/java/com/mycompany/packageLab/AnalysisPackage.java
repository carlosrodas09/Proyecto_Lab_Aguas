package com.mycompany.packageLab;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "ANALYSIS_PACKAGE")
public class AnalysisPackage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_analysis_package")
    private Integer idAnalysisPackage;
    @JoinColumn(name = "analysis_id", referencedColumnName = "id_analysis")
    @ManyToOne(optional = false)
    private Analysis analysisId;
    @JoinColumn(name = "package_id", referencedColumnName = "id_package")
    @ManyToOne(optional = false)
    private Package packageId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "analysisPackageId")
    private List<ParameterResult> parameterResultList;

    public AnalysisPackage() {
    }

    public AnalysisPackage(Integer idAnalysisPackage) {
        this.idAnalysisPackage = idAnalysisPackage;
    }

    public Integer getIdAnalysisPackage() {
        return idAnalysisPackage;
    }

    public void setIdAnalysisPackage(Integer idAnalysisPackage) {
        this.idAnalysisPackage = idAnalysisPackage;
    }

    public Analysis getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Analysis analysisId) {
        this.analysisId = analysisId;
    }

    public Package getPackageId() {
        return packageId;
    }

    public void setPackageId(Package packageId) {
        this.packageId = packageId;
    }

    public List<ParameterResult> getParameterResultList() {
        return parameterResultList;
    }

    public void setParameterResultList(List<ParameterResult> parameterResultList) {
        this.parameterResultList = parameterResultList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAnalysisPackage());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AnalysisPackage)) {
            return false;
        }
        AnalysisPackage other = (AnalysisPackage) object;
        return Objects.equals(getIdAnalysisPackage(), other.getIdAnalysisPackage());
    }

}
