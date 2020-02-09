
package com.mycompany.supply.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Maintenance;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class MaintenanceService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MaintenanceService() {
    }
    
    public Maintenance create(Maintenance newMantenance) throws MandatoryAttributeException{
        if (newMantenance.getEquipmentId() == null){
            throw new MandatoryAttributeException("Atributo Equipo Obligatorio");
        } 
        if (newMantenance.getProviderId()== null){
            throw new MandatoryAttributeException("Atributo Proveedor Obligatorio");
        }
        if (newMantenance.getMaintenanceCost() == null){
            throw new MandatoryAttributeException("Atributo Costo Obligatorio");
        }
        if (newMantenance.getMaintenanceDate()== null){
            throw new MandatoryAttributeException("Atributo Fecha Obligatorio");
        }
        entityManager.persist(newMantenance);
        return newMantenance;
    }
    
}
