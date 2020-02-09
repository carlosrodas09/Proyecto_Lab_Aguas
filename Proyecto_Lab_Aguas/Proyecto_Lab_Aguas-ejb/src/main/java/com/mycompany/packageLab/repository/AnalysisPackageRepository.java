package com.mycompany.packageLab.repository;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.AnalysisPackage;
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
public class AnalysisPackageRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<AnalysisPackage> findAnalysisPackageById(int id) {
        return Optional.of(entityManager.find(AnalysisPackage.class, id));
    }

    public List<AnalysisPackage> getAnalysisPackage(int idAnalysis, String idPackage) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AnalysisPackage> criteriaQuery = criteriaBuilder.createQuery(AnalysisPackage.class);
        Root<AnalysisPackage> analysisPackageR = criteriaQuery.from(AnalysisPackage.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (idAnalysis > 0) {
            predicates.add(criteriaBuilder.like(analysisPackageR.get("id_analysis"), "%" + idPackage + "%"));
        }
        if (idPackage != null) {
            predicates.add(criteriaBuilder.like(analysisPackageR.get("id_package"), "%" + idPackage + "%"));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<AnalysisPackage> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
