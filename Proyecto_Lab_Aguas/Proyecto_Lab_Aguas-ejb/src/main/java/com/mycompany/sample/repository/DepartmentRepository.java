package com.mycompany.sample.repository;

import com.mycompany.sample.repository.*;
import com.mycompany.sample.repository.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.sample.Department;
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
public class DepartmentRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public List<Department> getAllDepartment() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> rootEntry = criteriaQuery.from(Department.class);
        CriteriaQuery<Department> all = criteriaQuery.select(rootEntry);
        TypedQuery<Department> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    public List<Department> getDepartment(Department department){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> position = criteriaQuery.from(Department.class);
        List<Predicate> predicates = new ArrayList<>();
        if (department.getIdDepartment() != null) {
            predicates.add(criteriaBuilder.equal(position.get("idDepartment"), department.getIdDepartment()));
        }
        if (department.getNameDepartment() != null) {
            predicates.add(criteriaBuilder.like(position.get("nameDepartment"), "%" + department.getNameDepartment()+ "%"));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Department> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
