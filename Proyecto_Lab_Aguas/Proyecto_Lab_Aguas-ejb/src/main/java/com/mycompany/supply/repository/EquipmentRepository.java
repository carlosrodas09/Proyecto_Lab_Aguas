
package com.mycompany.supply.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.supply.Equipment;
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
public class EquipmentRepository {
    
    private EntityManager entityManager;
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EquipmentRepository() {
    }
    
    public List<Equipment> searchEquipment(Integer idEquipment, String nameEquipment, String modelEquipment){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteriaQuery = criteriaBuilder.createQuery(Equipment.class);
        Root<Equipment> equipment = criteriaQuery.from(Equipment.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        
        if (idEquipment != null){
            predicates.add(criteriaBuilder.like(equipment.get("idEquipment"), "%" + idEquipment + "%"));
        }
        
        if (nameEquipment != null){
            predicates.add(criteriaBuilder.like(equipment.get("nameEquipment"), "%" + nameEquipment + "%"));
        }
        
        if (modelEquipment != null){
            predicates.add(criteriaBuilder.like(equipment.get("modelEquipment"), "%" + modelEquipment + "%"));
        }
                
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Equipment> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
