package com.mycompany.packageLab.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterResult;
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
public class ParameterResultService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterResult createParameterResult(ParameterResult pr) {
        entityManager.persist(pr);
        return pr;
    }

}
