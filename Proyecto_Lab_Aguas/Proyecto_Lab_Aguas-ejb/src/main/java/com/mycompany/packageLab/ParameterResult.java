package com.mycompany.packageLab;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "PARAMETER_RESULT")
public class ParameterResult implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_parameter_result")
    private Integer idParameterResult;
    @Basic(optional = false)
    @Column(name = "result")
    private double result;
    @JoinColumn(name = "analysis_package_id", referencedColumnName = "id_analysis_package")
    @ManyToOne(optional = false)
    private AnalysisPackage analysisPackageId;
    @JoinColumn(name = "parameter_id", referencedColumnName = "id_parameter")
    @ManyToOne(optional = false)
    private Parameter parameterId;

    public ParameterResult() {
    }

    public ParameterResult(Integer idParameterResult) {
        this.idParameterResult = idParameterResult;
    }

    public ParameterResult(Integer idParameterResult, double result) {
        this.idParameterResult = idParameterResult;
        this.result = result;
    }

    public ParameterResult(Integer idParameterResult, double result, AnalysisPackage analysisPackageId, Parameter parameterId) {
        this.idParameterResult = idParameterResult;
        this.result = result;
        this.analysisPackageId = analysisPackageId;
        this.parameterId = parameterId;
    }

    public Integer getIdParameterResult() {
        return idParameterResult;
    }

    public void setIdParameterResult(Integer idParameterResult) {
        this.idParameterResult = idParameterResult;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public AnalysisPackage getAnalysisPackageId() {
        return analysisPackageId;
    }

    public void setAnalysisPackageId(AnalysisPackage analysisPackageId) {
        this.analysisPackageId = analysisPackageId;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdParameterResult());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ParameterResult)) {
            return false;
        }
        ParameterResult other = (ParameterResult) object;
        return Objects.equals(getIdParameterResult(), other.getIdParameterResult());
    }
    
}
