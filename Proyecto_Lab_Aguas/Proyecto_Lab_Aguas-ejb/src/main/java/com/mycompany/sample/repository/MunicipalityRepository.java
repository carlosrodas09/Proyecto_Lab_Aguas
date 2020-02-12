
package com.mycompany.sample.repository;


import com.mycompany.sample.repository.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.sample.Municipality;
import java.time.LocalDate;
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
public class MunicipalityRepository {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MunicipalityRepository() {
    }
    
     public List<Municipality> searchMunicipality(String municipalityName, Integer departmentId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipality> criteriaQuery = criteriaBuilder.createQuery(Municipality.class);
        Root<Municipality> municipality = criteriaQuery.from(Municipality.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (municipalityName != null){
            predicates.add(criteriaBuilder.like(municipality.get("municipalityName"), "%" + municipalityName + "%"));
        }
        
        if (departmentId != null){
            predicates.add(criteriaBuilder.like(municipality.get("providerId"), "%" + departmentId + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Municipality> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
