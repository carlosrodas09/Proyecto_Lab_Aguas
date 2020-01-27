package com.mycompany.packageLab.repository;

import static config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.Analysis;
import java.time.LocalDate;
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
public class AnalysisRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public Optional<Analysis> findAnalysisByID(Integer id) {
        return Optional.of(entityManager.find(Analysis.class, id));
    }

    public List<Analysis> getAnalysis(String DpiEmployee, String IdSample, LocalDate initDate, LocalDate endDate) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Analysis> criteriaQuery = criteriaBuilder.createQuery(Analysis.class);
        Root<Analysis> analysisR = criteriaQuery.from(Analysis.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (DpiEmployee != null) {
            predicates.add(criteriaBuilder.like(analysisR.get("employee_dpi"), "%" + DpiEmployee + "%"));
        }
        if (IdSample != null) {
            predicates.add(criteriaBuilder.like(analysisR.get("sample_id"), "%" + IdSample + "%"));
        }
        if (initDate != null & endDate != null && (initDate.isBefore(endDate))) {
            predicates.add(criteriaBuilder.between(analysisR.get("date_analysis"), initDate.toString(), endDate.toString()));
        }
        if (initDate != null && initDate.isBefore(LocalDate.now())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(analysisR.get("date_analysis"), initDate.toString()));
        }
        if (endDate != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(analysisR.get("date_analysis"), endDate.toString()));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Analysis> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
