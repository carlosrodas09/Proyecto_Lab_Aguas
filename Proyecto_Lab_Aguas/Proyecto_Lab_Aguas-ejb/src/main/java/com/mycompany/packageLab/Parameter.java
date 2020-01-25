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
@Table(name = "PARAMETER")
public class Parameter implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_parameter")
    private String idParameter;
    @Basic(optional = false)
    @Column(name = "name_parameter")
    private String nameParameter;
    @Basic(optional = false)
    @Column(name = "MR_code")
    private String mRcode;
    @Column(name = "below_limit")
    private Boolean belowLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterId")
    private List<ParameterPackage> parameterPackageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterId")
    private List<ParameterResult> parameterResultList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterId")
    private List<ParameterEquipment> parameterEquipmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parameterId")
    private List<ParameterSupply> parameterSupplyList;

    public Parameter() {
    }

    public Parameter(String idParameter) {
        this.idParameter = idParameter;
    }

    public Parameter(String idParameter, String nameParameter, String mRcode) {
        this.idParameter = idParameter;
        this.nameParameter = nameParameter;
        this.mRcode = mRcode;
    }

    public Parameter(String idParameter, String nameParameter, String mRcode, Boolean belowLimit, List<ParameterPackage> parameterPackageList, List<ParameterResult> parameterResultList, List<ParameterEquipment> parameterEquipmentList, List<ParameterSupply> parameterSupplyList) {
        this.idParameter = idParameter;
        this.nameParameter = nameParameter;
        this.mRcode = mRcode;
        this.belowLimit = belowLimit;
        this.parameterPackageList = parameterPackageList;
        this.parameterResultList = parameterResultList;
        this.parameterEquipmentList = parameterEquipmentList;
        this.parameterSupplyList = parameterSupplyList;
    }

    public String getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(String idParameter) {
        this.idParameter = idParameter;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public String getMRcode() {
        return mRcode;
    }

    public void setMRcode(String mRcode) {
        this.mRcode = mRcode;
    }

    public Boolean getBelowLimit() {
        return belowLimit;
    }

    public void setBelowLimit(Boolean belowLimit) {
        this.belowLimit = belowLimit;
    }

    public List<ParameterPackage> getParameterPackageList() {
        return parameterPackageList;
    }

    public void setParameterPackageList(List<ParameterPackage> parameterPackageList) {
        this.parameterPackageList = parameterPackageList;
    }

    public List<ParameterResult> getParameterResultList() {
        return parameterResultList;
    }

    public void setParameterResultList(List<ParameterResult> parameterResultList) {
        this.parameterResultList = parameterResultList;
    }

    public List<ParameterEquipment> getParameterEquipmentList() {
        return parameterEquipmentList;
    }

    public void setParameterEquipmentList(List<ParameterEquipment> parameterEquipmentList) {
        this.parameterEquipmentList = parameterEquipmentList;
    }

    public List<ParameterSupply> getParameterSupplyList() {
        return parameterSupplyList;
    }

    public void setParameterSupplyList(List<ParameterSupply> parameterSupplyList) {
        this.parameterSupplyList = parameterSupplyList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdParameter());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        return Objects.equals(getIdParameter(), other.getIdParameter());
    }

}
