package com.mycompany.packageLab.service;

import com.mycompany.packageLab.Parameter;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author angelrg
 */
public class ParameterService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Parameter creaParameter(Parameter parameter) {
        entityManager.persist(parameter);
        return parameter;
    }

    public Parameter updateParamenter(Parameter paramenter, String nameParameter, String mRcode) {
        if (nameParameter != null) {
            paramenter.setNameParameter(nameParameter);
        }
        if (mRcode != null) {
            paramenter.setMRcode(mRcode);
        }
        return entityManager.merge(paramenter);
    }

}
