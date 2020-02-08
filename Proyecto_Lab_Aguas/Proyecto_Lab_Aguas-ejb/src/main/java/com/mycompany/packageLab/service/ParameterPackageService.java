package com.mycompany.packageLab.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.packageLab.ParameterPackage;
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
public class ParameterPackageService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ParameterPackage createParameterPackage(ParameterPackage parameterPackage) {
        entityManager.persist(parameterPackage);
        return parameterPackage;
    }

    public ParameterPackage updateLMAandLMP(ParameterPackage pp, double lma, double lmp) {
        pp.setLma(lma);
        pp.setLmp(lmp);
        return entityManager.merge(pp);
    }

}
