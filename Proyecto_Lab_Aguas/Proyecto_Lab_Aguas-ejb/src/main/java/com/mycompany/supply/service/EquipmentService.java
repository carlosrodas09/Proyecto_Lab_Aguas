
package com.mycompany.supply.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Equipment;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EquipmentService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EquipmentService() {
    }
    
    public Equipment create(Equipment newEquipment) throws MandatoryAttributeException{
        if (newEquipment.getNameEquipment()== null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newEquipment.getModelEquipment()== null){
            throw new MandatoryAttributeException("Atributo Modelo Obligatorio");
        }
        entityManager.persist(newEquipment);
        return newEquipment;
    }
    
    public Equipment modify(Equipment equipment, String newName, String newModel) throws MandatoryAttributeException{
        if (newName == null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newModel == null){
            throw new MandatoryAttributeException("Atributo Modelo Obligatorio");
        }
        equipment.setNameEquipment(newName);
        equipment.setModelEquipment(newModel);
        return equipment;
    }
}
