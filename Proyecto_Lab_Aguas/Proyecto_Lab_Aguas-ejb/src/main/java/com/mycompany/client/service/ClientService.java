
package com.mycompany.client.service;

import com.mycompany.client.service.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.client.Client;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ClientService {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ClientService() {
    }
    
    public Client create(Client newClient) throws MandatoryAttributeException{
        if (newClient.getNameClient()== null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newClient.getPhoneClient()== null){
            throw new MandatoryAttributeException("Atributo Numero Obligatorio");
        }
        entityManager.persist(newClient);
        return newClient;
    }
    
     public Client modify(Client client, String newName, String newPhone) throws MandatoryAttributeException{
        if (newName == null){
            throw new MandatoryAttributeException("Atributo Nombre Obligatorio");
        } 
        if (newPhone == null){
            throw new MandatoryAttributeException("Atributo Telefono Obligatorio");
        }
        
        client.setNameClient(newName);
        client.setPhoneClient(newPhone);
        return client;
    }
}
