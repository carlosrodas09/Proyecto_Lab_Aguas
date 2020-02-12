
package com.mycompany.sample.service;

import com.mycompany.client.Client;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.sample.Municipality;
import com.mycompany.sample.Sample;
import exception.MandatoryAttributeException;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SampleService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public SampleService() {
    }
    
    public Sample create(Sample newSample) throws MandatoryAttributeException{
        if (newSample.getAdmissionDate()== null){
            throw new MandatoryAttributeException("Atributo Fecha de admision Obligatorio");
        } 
        if (newSample.getSamplingDate()== null){
            throw new MandatoryAttributeException("Atributo Fecha de toma de muestra Obligatorio");
        }
        if (newSample.getBatch() == null){
            throw new MandatoryAttributeException("Atributo Lote Obligatorio");
        }
        if (newSample.getSamplingTime()== null){
            throw new MandatoryAttributeException("Atributo hora de la muestra Obligatorio");
        }
        if (newSample.getIsRefrigerated()== false){
            throw new MandatoryAttributeException("Atributo Esta refrigerado Obligatorio");
        } 
        if (newSample.getTemperature()== 0){
            throw new MandatoryAttributeException("Atributo Temperatura Obligatorio");
        }
        if (newSample.getSampleQuantity() == 0){
            throw new MandatoryAttributeException("Atributo Cantidad Obligatorio");
        }
        if (newSample.getIsWaterBirth()== false){
            throw new MandatoryAttributeException("Atributo Es nacimiento de agua Obligatorio");
        }
        if (newSample.getAcceptance()== false){
            throw new MandatoryAttributeException("Atributo aceptacion Obligatorio");
        } 
        if (newSample.getMunicipalityId()== null){
            throw new MandatoryAttributeException("Atributo Id de Municipalidad Obligatorio");
        }
        if (newSample.getClientDpi() == null){
            throw new MandatoryAttributeException("Atributo Id de Cliente Obligatorio");
        }
        
        entityManager.persist(newSample);
        return newSample;
    }
    
     public Sample modify(Sample sample, Date admissionDate, Date samplingDate, String batch, Date samplingTime, Boolean isRefrigerated, Double temperature, Double cantidad, Boolean isWaterBirth, Boolean acceptance, Municipality municipalityId, Client clientDPI) throws MandatoryAttributeException{
        if (admissionDate == null){
            throw new MandatoryAttributeException("Atributo Fecha de admision Obligatorio");
        } 
        if (samplingDate== null){
            throw new MandatoryAttributeException("Atributo Fecha de toma de muestra Obligatorio");
        }
        if (batch == null){
            throw new MandatoryAttributeException("Atributo Lote Obligatorio");
        }
        if (samplingTime== null){
            throw new MandatoryAttributeException("Atributo hora de la muestra Obligatorio");
        }
        if (isRefrigerated == false){
            throw new MandatoryAttributeException("Atributo Esta refrigerado Obligatorio");
        } 
        if (temperature == 0){
            throw new MandatoryAttributeException("Atributo Temperatura Obligatorio");
        }
        if (cantidad == 0){
            throw new MandatoryAttributeException("Atributo Cantidad Obligatorio");
        }
        if (isWaterBirth== false){
            throw new MandatoryAttributeException("Atributo Es nacimiento de agua Obligatorio");
        }
        if (acceptance== false){
            throw new MandatoryAttributeException("Atributo aceptacion Obligatorio");
        } 
        if (municipalityId== null){
            throw new MandatoryAttributeException("Atributo Id de Municipalidad Obligatorio");
        }
        if (clientDPI == null){
            throw new MandatoryAttributeException("Atributo Id de Cliente Obligatorio");
        }
        sample.setAdmissionDate(admissionDate);
        sample.setSamplingDate(samplingDate);
        sample.setBatch(batch);
        sample.setSamplingTime(samplingTime);
        sample.setIsRefrigerated(isRefrigerated);
        sample.setTemperature(temperature);
        sample.setSampleQuantity(cantidad);
        sample.setIsWaterBirth(isWaterBirth);
        sample.setAcceptance(acceptance);
        sample.setMunicipalityId(municipalityId);
        sample.setClientDpi(clientDPI);
        return sample;
    }
}
