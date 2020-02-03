package com.mycompany.packageLab.repository;

import com.mycompany.packageLab.ParameterPackage;
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
public class ParameterPackageRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ParameterPackage> getParamenterPackageById(Integer id) {
        return Optional.of(entityManager.find(ParameterPackage.class, id));
    }

    public List<ParameterPackage> getParameterPackage(String idPackage, String idParamenter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParameterPackage> criteriaQuery = criteriaBuilder.createQuery(ParameterPackage.class);
        Root<ParameterPackage> parameterPackageR = criteriaQuery.from(ParameterPackage.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (idPackage != null) {
            predicates.add(criteriaBuilder.like(parameterPackageR.get("package_id"), "%" + idPackage + "%"));
        }
        if (idParamenter != null) {
            predicates.add(criteriaBuilder.like(parameterPackageR.get("parameter_id"), "%" + idParamenter + "%"));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<ParameterPackage> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
