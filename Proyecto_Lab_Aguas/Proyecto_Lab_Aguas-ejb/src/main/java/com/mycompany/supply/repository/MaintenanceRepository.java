
package com.mycompany.supply.repository;


import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Maintenance;
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
public class MaintenanceRepository {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MaintenanceRepository() {
    }
    
     public List<Maintenance> searchSupply(LocalDate maintenanceDate, Double maintenanceCost, Integer equipmentId, Integer providerId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Maintenance> criteriaQuery = criteriaBuilder.createQuery(Maintenance.class);
        Root<Maintenance> supply = criteriaQuery.from(Maintenance.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (maintenanceDate != null){
            predicates.add(criteriaBuilder.like(supply.get("maintenanceDate"), "%" + maintenanceDate + "%"));
        }
        
        if (maintenanceCost != null){
            predicates.add(criteriaBuilder.like(supply.get("maintenanceCost"), "%" + maintenanceCost + "%"));
        }
        
        if (providerId != null){
            predicates.add(criteriaBuilder.like(supply.get("providerId"), "%" + providerId + "%"));
        }
        
        if (equipmentId != null){
            predicates.add(criteriaBuilder.like(supply.get("equipmentId"), "%" + equipmentId + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Maintenance> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
