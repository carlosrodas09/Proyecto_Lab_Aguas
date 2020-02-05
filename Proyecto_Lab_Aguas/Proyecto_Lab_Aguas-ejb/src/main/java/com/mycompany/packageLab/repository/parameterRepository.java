package com.mycompany.packageLab.repository;

import com.mycompany.packageLab.Parameter;
import static config.Constants.PERSISTENCE_UNIT_NAME;
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

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class parameterRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Parameter> findParameterById(String id) {
        return Optional.of(entityManager.find(Parameter.class, id));
    }

    public List<Parameter> getParameters(String id, String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Parameter> criteriaQuery = criteriaBuilder.createQuery(Parameter.class);
        Root<Parameter> parameterR = criteriaQuery.from(Parameter.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (id != null) {
            predicates.add(criteriaBuilder.like(parameterR.get("id_parameter"), "%" + id + "%"));
        }
        if (name != null) {
            predicates.add(criteriaBuilder.like(parameterR.get("name_parameter"), "%" + name + "%"));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Parameter> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
