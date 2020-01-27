
package com.mycompany.supply.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Supply;
import com.mycompany.exceptions.MandatoryAttributeException;
import com.mycompany.supply.Measure;
import java.time.LocalDate;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SupplyService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public SupplyService() {
    }
    
    public Supply create(Supply newSupply) throws MandatoryAttributeException{
        if (newSupply.getNameSupply()== null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newSupply.getDateExpiry()== null){
            throw new MandatoryAttributeException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newSupply.getQuantityAvailable() == null){
            throw new MandatoryAttributeException("Atributo Cantidad Obligatorio");
        }
        if (newSupply.getMeasureId()== null){
            throw new MandatoryAttributeException("Atributo Medida Obligatorio");
        }
        entityManager.persist(newSupply);
        return newSupply;
    }
    
     public Supply modify(Supply supply, String newName, LocalDate newExpirationDate, Double newQuantityAvailable, byte[] newSecuritySheet, Measure newMeasure) throws MandatoryAttributeException{
        if (newName == null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newExpirationDate == null){
            throw new MandatoryAttributeException("Atributo Fecha de Expiración Obligatorio");
        }
        if (newQuantityAvailable == null){
            throw new MandatoryAttributeException("Atributo Costo Obligatorio");
        }
        if (newMeasure == null){
            throw new MandatoryAttributeException("Atributo Medida Obligatorio");
        }
        supply.setNameSupply(newName);
        supply.setDateExpiry(newExpirationDate);
        supply.setQuantityAvailable(newQuantityAvailable);
        supply.setSecuritySheet(newSecuritySheet);
        supply.setMeasureId(newMeasure);
        return supply;
    }
}
