
package com.mycompany.supply.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Provider;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ProviderService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ProviderService() {
    }
    
    public Provider create(Provider newProvider) throws MandatoryAttributeException{
        if (newProvider.getNitProvider()== null){
            throw new MandatoryAttributeException("Atributo NIT Obligatorio");
        } 
        if (newProvider.getNameProvider()== null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        }
        if (newProvider.getPhoneProvider() == null){
            throw new MandatoryAttributeException("Atributo Telefono Obligatorio");
        }
        entityManager.persist(newProvider);
        return newProvider;
    }
    
     public Provider modify(Provider provider, String newName, String newPhone, String newNIT) throws MandatoryAttributeException{
        if (newName == null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newPhone == null){
            throw new MandatoryAttributeException("Atributo Telefono Obligatorio");
        }
        if (newNIT == null){
            throw new MandatoryAttributeException("Atributo NIT Obligatorio");
        }
        
        provider.setNameProvider(newName);
        provider.setPhoneProvider(newPhone);
        provider.setNitProvider(newNIT);
        return provider;
    }
}
