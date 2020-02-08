package com.mycompany.packageLab.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterResult;
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
public class ParameterResultRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<ParameterResult> findParameterResultById(Integer id) {
        return Optional.of(entityManager.find(ParameterResult.class, id));
    }

    public List<ParameterResult> gerParameterResult(Integer idParameterResult, Integer analysisPackageId, Integer parameterId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParameterResult> criteriaQuery = criteriaBuilder.createQuery(ParameterResult.class);
        Root<ParameterResult> parameterR = criteriaQuery.from(ParameterResult.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (idParameterResult != null) {
            predicates.add(criteriaBuilder.like(parameterR.get("analysis_package_id"), "%" + idParameterResult + "%"));
        }
        if (analysisPackageId != null) {
            predicates.add(criteriaBuilder.equal(parameterR.get("analysis_package_id"), analysisPackageId));
        }
        if (parameterId != null) {
            predicates.add(criteriaBuilder.equal(parameterR.get("parameter_id"), parameterId));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<ParameterResult> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
