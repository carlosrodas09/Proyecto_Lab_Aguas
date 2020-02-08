
package com.mycompany.packageLab.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterSupply;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ParameterSupplyService {
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterSupplyService() {
    }
    
    public ParameterSupply create(ParameterSupply newParameterSupply) throws MandatoryAttributeException{
        if (newParameterSupply.getSupplyId()== null){
            throw new MandatoryAttributeException("Atributo Insumo Obligatorio");
        } 
        if (newParameterSupply.getParameterId()== null){
            throw new MandatoryAttributeException("Atributo Parametro Obligatorio");
        }
        if (newParameterSupply.getAmountUsed() == null){
            throw new MandatoryAttributeException("Atributo Cantidad Usada Obligatorio");
        }
        entityManager.persist(newParameterSupply);
        return newParameterSupply;
    }
    
     public ParameterSupply modify(ParameterSupply parameterSupply, Double newAmountUsed) throws MandatoryAttributeException{
        if (newAmountUsed == null){
            throw new MandatoryAttributeException("Atributo CantidadUsadas Obligatorio");
        } 
        parameterSupply.setAmountUsed(newAmountUsed);
        return parameterSupply;
    }
}
