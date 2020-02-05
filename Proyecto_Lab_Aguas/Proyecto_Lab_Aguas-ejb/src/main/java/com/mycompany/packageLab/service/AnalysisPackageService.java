package com.mycompany.packageLab.service;

import com.mycompany.packageLab.AnalysisPackage;
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
public class AnalysisPackageService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AnalysisPackage createAnalysisPackage(AnalysisPackage analysisPackage) {
        entityManager.persist(analysisPackage);
        return analysisPackage;
    }

}
