
package com.mycompany.supply.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Shopping;
import exception.MandatoryAttributeException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ShoppingService {
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ShoppingService() {
    }

    public Shopping create(Shopping newShopping) throws MandatoryAttributeException{
        if (newShopping.getAmountPurchased() == null){
            throw new MandatoryAttributeException("Atributo Cantidad Comprada Obligatorio");
        } 
        if (newShopping.getDateShopping()== null){
            throw new MandatoryAttributeException("Atributo Fecha de Compra Obligatorio");
        }
        if (newShopping.getProviderId() == null){
            throw new MandatoryAttributeException("Atributo Proveedor Obligatorio");
        }
        entityManager.persist(newShopping);
        return newShopping;
    }
}
