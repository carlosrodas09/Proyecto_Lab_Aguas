package com.mycompany.packageLab.service;

import com.mycompany.packageLab.Analysis;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelrg
 */
@Stateless
@LocalBean
public class AnalysisService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Analysis createAnalysis(Analysis analysis) {
        entityManager.persist(analysis);
        return analysis;
    }

}
