
package com.mycompany.supply.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Provider;
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
public class ProviderRepository {
    
    private  EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ProviderRepository() {
    }
    
     public List<Provider> searchSupply(Integer nitProvider, String nameProvider){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Provider> criteriaQuery = criteriaBuilder.createQuery(Provider.class);
        Root<Provider> supply = criteriaQuery.from(Provider.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (nitProvider != null){
            predicates.add(criteriaBuilder.like(supply.get("nitProvider"), "%" + nitProvider + "%"));
        }
        
        if (nameProvider != null){
            predicates.add(criteriaBuilder.like(supply.get("nameProvider"), "%" + nameProvider + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Provider> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
}
