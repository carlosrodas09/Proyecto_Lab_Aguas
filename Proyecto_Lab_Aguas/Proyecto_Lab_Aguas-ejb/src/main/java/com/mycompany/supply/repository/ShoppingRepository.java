
package com.mycompany.supply.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Shopping;
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
public class ShoppingRepository {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ShoppingRepository() {
    }
    
    public List<Shopping> searchShopping(Integer idShopping, Integer idProvider){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shopping> criteriaQuery = criteriaBuilder.createQuery(Shopping.class);
        Root<Shopping> shopping = criteriaQuery.from(Shopping.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (idShopping != null){
            predicates.add(criteriaBuilder.like(shopping.get("idShopping"), "%" + idShopping + "%"));
        }
        
        if (idProvider != null){
            predicates.add(criteriaBuilder.like(shopping.get("providerId"), "%" + idProvider + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Shopping> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
