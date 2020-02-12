
package com.mycompany.sample.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.sample.Sample;
import com.mycompany.supply.Supply;
import static com.mycompany.supply.Supply_.nameSupply;
import java.util.ArrayList;
import java.util.Date;
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
public class SampleRepository {
    
    private EntityManager entityManager;
    
    public SampleRepository(){
    }
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Sample> searchSupply(Integer codeSample, Date admissionDateSample){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sample> criteriaQuery = criteriaBuilder.createQuery(Sample.class);
        Root<Sample> sample = criteriaQuery.from(Sample.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (codeSample != null){
            predicates.add(criteriaBuilder.like(sample.get("code"), "%" + codeSample + "%"));
        }
        
        if (admissionDateSample != null){
            predicates.add(criteriaBuilder.like(sample.get("admissionDate"), "%" + admissionDateSample + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Sample> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
