package com.mycompany.employee.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.employee.StaffPosition;
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
public class StaffPositionRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public List<StaffPosition> getAllRolUser() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StaffPosition> criteriaQuery = criteriaBuilder.createQuery(StaffPosition.class);
        Root<StaffPosition> rootEntry = criteriaQuery.from(StaffPosition.class);
        CriteriaQuery<StaffPosition> all = criteriaQuery.select(rootEntry);
        TypedQuery<StaffPosition> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    public List<StaffPosition> getStaffPosition(StaffPosition staffPosition){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StaffPosition> criteriaQuery = criteriaBuilder.createQuery(StaffPosition.class);
        Root<StaffPosition> position = criteriaQuery.from(StaffPosition.class);
        List<Predicate> predicates = new ArrayList<>();
        if (staffPosition.getIdStaffPosition() != null) {
            predicates.add(criteriaBuilder.equal(position.get("idStaffPosition"), staffPosition.getIdStaffPosition()));
        }
        if (staffPosition.getNameStaffPosition() != null) {
            predicates.add(criteriaBuilder.like(position.get("nameStaffPosition"), "%" + staffPosition.getNameStaffPosition()+ "%"));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<StaffPosition> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
