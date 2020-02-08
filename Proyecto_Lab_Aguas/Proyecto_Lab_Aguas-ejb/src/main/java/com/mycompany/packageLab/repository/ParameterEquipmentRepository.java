
package com.mycompany.packageLab.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
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
public class ParameterEquipmentRepository {
    
    private EntityManager entityManager;

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterEquipmentRepository() {
    }
    
    public List<ParameterEquipmentRepository> searchParameterSupply(Integer idEquipment, String parameterId){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParameterEquipmentRepository> criteriaQuery = criteriaBuilder.createQuery(ParameterEquipmentRepository.class);
        Root<ParameterEquipmentRepository> supply = criteriaQuery.from(ParameterEquipmentRepository.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (parameterId != null){
            predicates.add(criteriaBuilder.like(supply.get("parameterId"), "%" + parameterId + "%"));
        }
        
        if (idEquipment != null){
            predicates.add(criteriaBuilder.like(supply.get("equipmentId"), "%" + idEquipment + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<ParameterEquipmentRepository> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
