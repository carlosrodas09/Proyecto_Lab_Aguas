
package com.mycompany.supply.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Supply;
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
public class SupplyRepository {
    
    private EntityManager entityManager;
    
    public SupplyRepository(){
    }
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Supply> searchSupply(Integer codeSupply, String nameSupply){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Supply> criteriaQuery = criteriaBuilder.createQuery(Supply.class);
        Root<Supply> supply = criteriaQuery.from(Supply.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (codeSupply != null){
            predicates.add(criteriaBuilder.like(supply.get("code"), "%" + codeSupply + "%"));
        }
        
        if (nameSupply != null){
            predicates.add(criteriaBuilder.like(supply.get("name"), "%" + nameSupply + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Supply> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
