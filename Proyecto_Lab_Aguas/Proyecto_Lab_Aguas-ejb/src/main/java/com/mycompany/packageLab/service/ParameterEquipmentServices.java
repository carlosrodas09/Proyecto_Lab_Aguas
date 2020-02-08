
package com.mycompany.packageLab.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterEquipment;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ParameterEquipmentServices {
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterEquipmentServices() {
    }
    
    public ParameterEquipment create(ParameterEquipment newParameterEquipment) throws MandatoryAttributeException{
        if (newParameterEquipment.getEquipmentId()== null){
            throw new MandatoryAttributeException("Atributo Equipo Obligatorio");
        } 
        if (newParameterEquipment.getParameterId()== null){
            throw new MandatoryAttributeException("Atributo Parametro Obligatorio");
        }
        if (newParameterEquipment.getWorkingHours() == null){
            throw new MandatoryAttributeException("Atributo Horas Trabajadas Obligatorio");
        }
        entityManager.persist(newParameterEquipment);
        return newParameterEquipment;
    }
    
     public ParameterEquipment modify(ParameterEquipment parameterEquipment, Double newWorkingHours) throws MandatoryAttributeException{
        if (newWorkingHours == null){
            throw new MandatoryAttributeException("Atributo Horas Trabajadas Obligatorio");
        } 
        parameterEquipment.setWorkingHours(newWorkingHours);
        return parameterEquipment;
    }
}
