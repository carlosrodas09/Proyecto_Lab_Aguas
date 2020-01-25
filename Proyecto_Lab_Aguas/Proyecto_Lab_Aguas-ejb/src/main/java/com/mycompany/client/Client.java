package com.mycompany.client;

import com.mycompany.sample.Sample;
import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "dpi_client")
    private String dpiClient;
    @Basic(optional = false)
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "direction_client")
    private String directionClient;
    @Column(name = "city_client")
    private String cityClient;
    @Column(name = "company_client")
    private String companyClient;
    @Basic(optional = false)
    @Column(name = "phone_client")
    private String phoneClient;
    @Column(name = "phone_client_extra")
    private String phoneClientExtra;
    @Column(name = "phone_extra")
    private String phoneExtra;
    @Column(name = "email_client")
    private String emailClient;
    @Column(name = "web_site_client")
    private String webSiteClient;
    @JoinColumn(name = "costum_client_id", referencedColumnName = "id_costum_category")
    @ManyToOne(optional = false)
    private CostumClient costumClientId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "clientDpi")
    private Collection<Sample> sampleCollection;

    public Client() {
    }

    public Client(String dpiClient) {
        this.dpiClient = dpiClient;
    }

    public Client(String dpiClient, String nameClient, String phoneClient) {
        this.dpiClient = dpiClient;
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
    }

    public Client(String dpiClient, String nameClient, String directionClient, String cityClient, String companyClient, String phoneClient, String phoneClientExtra, String phoneExtra, String emailClient, String webSiteClient, CostumClient costumClientId, Collection<Sample> sampleCollection) {
        this.dpiClient = dpiClient;
        this.nameClient = nameClient;
        this.directionClient = directionClient;
        this.cityClient = cityClient;
        this.companyClient = companyClient;
        this.phoneClient = phoneClient;
        this.phoneClientExtra = phoneClientExtra;
        this.phoneExtra = phoneExtra;
        this.emailClient = emailClient;
        this.webSiteClient = webSiteClient;
        this.costumClientId = costumClientId;
        this.sampleCollection = sampleCollection;
    }

    public String getDpiClient() {
        return dpiClient;
    }

    public void setDpiClient(String dpiClient) {
        this.dpiClient = dpiClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getDirectionClient() {
        return directionClient;
    }

    public void setDirectionClient(String directionClient) {
        this.directionClient = directionClient;
    }

    public String getCityClient() {
        return cityClient;
    }

    public void setCityClient(String cityClient) {
        this.cityClient = cityClient;
    }

    public String getCompanyClient() {
        return companyClient;
    }

    public void setCompanyClient(String companyClient) {
        this.companyClient = companyClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getPhoneClientExtra() {
        return phoneClientExtra;
    }

    public void setPhoneClientExtra(String phoneClientExtra) {
        this.phoneClientExtra = phoneClientExtra;
    }

    public String getPhoneExtra() {
        return phoneExtra;
    }

    public void setPhoneExtra(String phoneExtra) {
        this.phoneExtra = phoneExtra;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getWebSiteClient() {
        return webSiteClient;
    }

    public void setWebSiteClient(String webSiteClient) {
        this.webSiteClient = webSiteClient;
    }

    public CostumClient getCostumClientId() {
        return costumClientId;
    }

    public void setCostumClientId(CostumClient costumClientId) {
        this.costumClientId = costumClientId;
    }

    @XmlTransient
    public Collection<Sample> getSampleCollection() {
        return sampleCollection;
    }

    public void setSampleCollection(Collection<Sample> sampleCollection) {
        this.sampleCollection = sampleCollection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDpiClient());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Client)) {
            return false;
        }
        Client client = (Client) object;
        return Objects.equals(getDpiClient(), client.getDpiClient());
    }

}
