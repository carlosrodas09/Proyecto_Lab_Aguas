
package com.mycompany.packageLab.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterSupply;
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
public class ParameterSupplyRepository {
    
    private EntityManager entityManager;

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterSupplyRepository() {
    }
    
    public List<ParameterSupply> searchParameterSupply(Integer idSupply, String parameterId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParameterSupply> criteriaQuery = criteriaBuilder.createQuery(ParameterSupply.class);
        Root<ParameterSupply> supply = criteriaQuery.from(ParameterSupply.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (parameterId != null){
            predicates.add(criteriaBuilder.like(supply.get("parameterId"), "%" + parameterId + "%"));
        }
        
        if (idSupply != null){
            predicates.add(criteriaBuilder.like(supply.get("supplyId"), "%" + idSupply + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<ParameterSupply> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
