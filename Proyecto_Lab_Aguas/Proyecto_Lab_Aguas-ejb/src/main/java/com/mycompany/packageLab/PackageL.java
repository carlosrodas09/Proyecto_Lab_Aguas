package com.mycompany.packageLab;

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
@Table(name = "PACKAGE")
public class PackageL implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_package")
    private String idPackage;
    @Basic(optional = false)
    @Column(name = "name_package")
    private String namePackage;
    @Basic(optional = false)
    @Column(name = "package_cost")
    private double packageCost;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "packageId")
    private List<AnalysisPackage> analysisPackageList;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "packageId")
    private List<ParameterPackage> parameterPackageList;

    public PackageL() {
    }

    public PackageL(String idPackage) {
        this.idPackage = idPackage;
    }

    public PackageL(String idPackage, String namePackage, double packageCost) {
        this.idPackage = idPackage;
        this.namePackage = namePackage;
        this.packageCost = packageCost;
    }

    public String getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(String idPackage) {
        this.idPackage = idPackage;
    }

    public String getNamePackage() {
        return namePackage;
    }

    public void setNamePackage(String namePackage) {
        this.namePackage = namePackage;
    }

    public double getPackageCost() {
        return packageCost;
    }

    public void setPackageCost(double packageCost) {
        this.packageCost = packageCost;
    }

    public List<AnalysisPackage> getAnalysisPackageList() {
        return analysisPackageList;
    }

    public void setAnalysisPackageList(List<AnalysisPackage> analysisPackageList) {
        this.analysisPackageList = analysisPackageList;
    }

    public List<ParameterPackage> getParameterPackageList() {
        return parameterPackageList;
    }

    public void setParameterPackageList(List<ParameterPackage> parameterPackageList) {
        this.parameterPackageList = parameterPackageList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPackage());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PackageL)) {
            return false;
        }
        PackageL other = (PackageL) object;
        return Objects.equals(getIdPackage(), other.getIdPackage());
    }
    
}
