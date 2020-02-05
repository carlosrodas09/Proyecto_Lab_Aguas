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
@Table(name = "PARAMETER_PACKAGE")
public class ParameterPackage implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_PP")
    private Integer idPP;
    @Basic(optional = false)
    @Column(name = "LMA")
    private double lma;
    @Basic(optional = false)
    @Column(name = "LMP")
    private double lmp;
    @JoinColumn(name = "package_id", referencedColumnName = "id_package")
    @ManyToOne(optional = false)
    private PackageL packageId;
    @JoinColumn(name = "parameter_id", referencedColumnName = "id_parameter")
    @ManyToOne(optional = false)
    private Parameter parameterId;

    public ParameterPackage() {
    }

    public ParameterPackage(Integer idPP) {
        this.idPP = idPP;
    }

    public ParameterPackage(Integer idPP, double lma, double lmp) {
        this.idPP = idPP;
        this.lma = lma;
        this.lmp = lmp;
    }

    public ParameterPackage(Integer idPP, double lma, double lmp, PackageL packageId, Parameter parameterId) {
        this.idPP = idPP;
        this.lma = lma;
        this.lmp = lmp;
        this.packageId = packageId;
        this.parameterId = parameterId;
    }

    public Integer getIdPP() {
        return idPP;
    }

    public void setIdPP(Integer idPP) {
        this.idPP = idPP;
    }

    public double getLma() {
        return lma;
    }

    public void setLma(double lma) {
        this.lma = lma;
    }

    public double getLmp() {
        return lmp;
    }

    public void setLmp(double lmp) {
        this.lmp = lmp;
    }

    public PackageL getPackageId() {
        return packageId;
    }

    public void setPackageId(PackageL packageId) {
        this.packageId = packageId;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPP());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ParameterPackage)) {
            return false;
        }
        ParameterPackage other = (ParameterPackage) object;
        return Objects.equals(getIdPP(), other.getIdPP());
    }
}
