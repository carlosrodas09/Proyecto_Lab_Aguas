
package com.mycompany.sample.service;

import com.mycompany.sample.service.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.sample.Municipality;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class MunicipalityService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MunicipalityService() {
    }
    
    public Municipality create(Municipality newMunicipality) throws MandatoryAttributeException{
        if (newMunicipality.getNameMunicipality() == null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newMunicipality.getDepartmentId()== null){
            throw new MandatoryAttributeException("Atributo Departamento Obligatorio");
        }
        
        entityManager.persist(newMunicipality);
        return newMunicipality;
    }
    
}
