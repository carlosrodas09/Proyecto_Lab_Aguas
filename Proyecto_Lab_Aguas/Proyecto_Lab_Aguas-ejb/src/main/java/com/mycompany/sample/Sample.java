package com.mycompany.sample;

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
import com.mycompany.packageLab.Analysis;
import com.mycompany.client.Client;

/**
 *
 * @author angelrg
 */
@Entity
@Table(name = "SAMPLE")
public class Sample implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_sample")
    private Integer idSample;
    @Basic(optional = false)
    @Column(name = "admission_date")
    @Temporal(TemporalType.DATE)
    private Date admissionDate;
    @Basic(optional = false)
    @Column(name = "sampling_date")
    @Temporal(TemporalType.DATE)
    private Date samplingDate;
    @Basic(optional = false)
    @Column(name = "batch")
    private String batch;
    @Basic(optional = false)
    @Column(name = "sampling_time")
    @Temporal(TemporalType.TIME)
    private Date samplingTime;
    @Column(name = "container")
    private String container;
    @Basic(optional = false)
    @Column(name = "is_refrigerated")
    private boolean isRefrigerated;
    @Basic(optional = false)
    @Column(name = "temperature")
    private double temperature;
    @Basic(optional = false)
    @Column(name = "sample_quantity")
    private double sampleQuantity;
    @Basic(optional = false)
    @Column(name = "is_water_birth")
    private boolean isWaterBirth;
    @Column(name = "hamlet")
    private String hamlet;
    @Column(name = "observations")
    private String observations;
    @Column(name = "village")
    private String village;
    @Column(name = "note_sample")
    private String noteSample;
    @Basic(optional = false)
    @Column(name = "acceptance")
    private boolean acceptance;
    @Column(name = "Boleta_de_pago")
    private String boletadepago;
    @Column(name = "no_hoja_campo")
    private String noHojaCampo;
    @Column(name = "tecnico_evaluador")
    private String tecnicoEvaluador;
    @Column(name = "coordenadas")
    private String coordenadas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura_lugar")
    private Double temperaturaLugar;
    @Column(name = "ph_lugar")
    private Double phLugar;
    @Column(name = "std_lugar")
    private String stdLugar;
    @Column(name = "u_s_lugar")
    private String uSLugar;
    @Column(name = "salinidad_lugar")
    private String salinidadLugar;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sampleId")
    private List<Analysis> analysisList;
    @JoinColumn(name = "client_dpi", referencedColumnName = "dpi_client")
    @ManyToOne(optional = false)
    private Client clientDpi;
    @JoinColumn(name = "municipality_id", referencedColumnName = "id_municipality")
    @ManyToOne(optional = false)
    private Municipality municipalityId;

    public Sample() {
    }

    public Sample(Integer idSample) {
        this.idSample = idSample;
    }

    public Sample(Integer idSample, Date admissionDate, Date samplingDate, String batch, Date samplingTime, boolean isRefrigerated, double temperature, double sampleQuantity, boolean isWaterBirth, boolean acceptance) {
        this.idSample = idSample;
        this.admissionDate = admissionDate;
        this.samplingDate = samplingDate;
        this.batch = batch;
        this.samplingTime = samplingTime;
        this.isRefrigerated = isRefrigerated;
        this.temperature = temperature;
        this.sampleQuantity = sampleQuantity;
        this.isWaterBirth = isWaterBirth;
        this.acceptance = acceptance;
    }

    public Sample(Integer idSample, Date admissionDate, Date samplingDate, String batch, Date samplingTime, String container, boolean isRefrigerated, double temperature, double sampleQuantity, boolean isWaterBirth, String hamlet, String observations, String village, String noteSample, boolean acceptance, String boletadepago, String noHojaCampo, String tecnicoEvaluador, String coordenadas, Double temperaturaLugar, Double phLugar, String stdLugar, String uSLugar, String salinidadLugar, List<Analysis> analysisList, Client clientDpi, Municipality municipalityId) {
        this.idSample = idSample;
        this.admissionDate = admissionDate;
        this.samplingDate = samplingDate;
        this.batch = batch;
        this.samplingTime = samplingTime;
        this.container = container;
        this.isRefrigerated = isRefrigerated;
        this.temperature = temperature;
        this.sampleQuantity = sampleQuantity;
        this.isWaterBirth = isWaterBirth;
        this.hamlet = hamlet;
        this.observations = observations;
        this.village = village;
        this.noteSample = noteSample;
        this.acceptance = acceptance;
        this.boletadepago = boletadepago;
        this.noHojaCampo = noHojaCampo;
        this.tecnicoEvaluador = tecnicoEvaluador;
        this.coordenadas = coordenadas;
        this.temperaturaLugar = temperaturaLugar;
        this.phLugar = phLugar;
        this.stdLugar = stdLugar;
        this.uSLugar = uSLugar;
        this.salinidadLugar = salinidadLugar;
        this.analysisList = analysisList;
        this.clientDpi = clientDpi;
        this.municipalityId = municipalityId;
    }

    public Integer getIdSample() {
        return idSample;
    }

    public void setIdSample(Integer idSample) {
        this.idSample = idSample;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getSamplingDate() {
        return samplingDate;
    }

    public void setSamplingDate(Date samplingDate) {
        this.samplingDate = samplingDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Date getSamplingTime() {
        return samplingTime;
    }

    public void setSamplingTime(Date samplingTime) {
        this.samplingTime = samplingTime;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public boolean getIsRefrigerated() {
        return isRefrigerated;
    }

    public void setIsRefrigerated(boolean isRefrigerated) {
        this.isRefrigerated = isRefrigerated;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSampleQuantity() {
        return sampleQuantity;
    }

    public void setSampleQuantity(double sampleQuantity) {
        this.sampleQuantity = sampleQuantity;
    }

    public boolean getIsWaterBirth() {
        return isWaterBirth;
    }

    public void setIsWaterBirth(boolean isWaterBirth) {
        this.isWaterBirth = isWaterBirth;
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getNoteSample() {
        return noteSample;
    }

    public void setNoteSample(String noteSample) {
        this.noteSample = noteSample;
    }

    public boolean getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(boolean acceptance) {
        this.acceptance = acceptance;
    }

    public String getBoletadepago() {
        return boletadepago;
    }

    public void setBoletadepago(String boletadepago) {
        this.boletadepago = boletadepago;
    }

    public String getNoHojaCampo() {
        return noHojaCampo;
    }

    public void setNoHojaCampo(String noHojaCampo) {
        this.noHojaCampo = noHojaCampo;
    }

    public String getTecnicoEvaluador() {
        return tecnicoEvaluador;
    }

    public void setTecnicoEvaluador(String tecnicoEvaluador) {
        this.tecnicoEvaluador = tecnicoEvaluador;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Double getTemperaturaLugar() {
        return temperaturaLugar;
    }

    public void setTemperaturaLugar(Double temperaturaLugar) {
        this.temperaturaLugar = temperaturaLugar;
    }

    public Double getPhLugar() {
        return phLugar;
    }

    public void setPhLugar(Double phLugar) {
        this.phLugar = phLugar;
    }

    public String getStdLugar() {
        return stdLugar;
    }

    public void setStdLugar(String stdLugar) {
        this.stdLugar = stdLugar;
    }

    public String getUSLugar() {
        return uSLugar;
    }

    public void setUSLugar(String uSLugar) {
        this.uSLugar = uSLugar;
    }

    public String getSalinidadLugar() {
        return salinidadLugar;
    }

    public void setSalinidadLugar(String salinidadLugar) {
        this.salinidadLugar = salinidadLugar;
    }

    public List<Analysis> getAnalysisList() {
        return analysisList;
    }

    public void setAnalysisList(List<Analysis> analysisList) {
        this.analysisList = analysisList;
    }

    public Client getClientDpi() {
        return clientDpi;
    }

    public void setClientDpi(Client clientDpi) {
        this.clientDpi = clientDpi;
    }

    public Municipality getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Municipality municipalityId) {
        this.municipalityId = municipalityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdSample());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Sample)) {
            return false;
        }
        Sample other = (Sample) object;
        return Objects.equals(getIdSample(), other.getIdSample());
    }

}
