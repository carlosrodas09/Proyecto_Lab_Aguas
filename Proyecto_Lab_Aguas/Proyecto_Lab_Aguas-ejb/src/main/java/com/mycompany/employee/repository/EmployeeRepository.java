package com.mycompany.employee.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.employee.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class EmployeeRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public List<Employee> getUser(Employee employee) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> userR = criteriaQuery.from(Employee.class);
        List<Predicate> predicates = new ArrayList<>();
        if (employee.getDpiEmployee() != null) {
            predicates.add(criteriaBuilder.equal(userR.get("dpiEmployee"), employee.getDpiEmployee()));
        }
        if (employee.getNameEmployee() != null) {
            predicates.add(criteriaBuilder.like(userR.get("nameEmployee"), "%" + employee.getNameEmployee() + "%"));
        }
        if (employee.getIsActive() != null) {
            predicates.add(criteriaBuilder.equal(userR.get("isActive"), employee.getIsActive()));
        }
        if (employee.getPhoneEmployee() != null) {
            predicates.add(criteriaBuilder.equal(userR.get("phoneEmployee"), employee.getPhoneEmployee()));
        }
        if (employee.getStaffPositionId() != null) {
            predicates.add(criteriaBuilder.equal(userR.get("staffPositionId"), employee.getStaffPositionId().getIdStaffPosition()));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
