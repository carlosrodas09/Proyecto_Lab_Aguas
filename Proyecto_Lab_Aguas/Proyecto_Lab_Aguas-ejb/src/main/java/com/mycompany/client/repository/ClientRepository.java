
package com.mycompany.client.repository;

import com.mycompany.client.repository.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.client.Client;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class ClientRepository {
    
    private  EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ClientRepository() {
    }
    
     public List<Client> searchClient(Integer phoneClient, String nameClient){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> client = criteriaQuery.from(Client.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (phoneClient != null){
            predicates.add(criteriaBuilder.like(client.get("phoneClient"), "%" + phoneClient + "%"));
        }
        
        if (nameClient != null){
            predicates.add(criteriaBuilder.like(client.get("nameClient"), "%" + nameClient + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Client> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
