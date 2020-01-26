package com.mycompany.packageLab.service;

import com.mycompany.packageLab.Analysis;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.List;
import java.util.Optional;
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
public class AnalysisRepository {

    public static final String GET_ALL_GROUP_USERS = "SELECT a FROM Analysis a";

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public Optional<Analysis> findAnalysisByID(Integer id) {
        return Optional.of(entityManager.find(Analysis.class, id));
    }

//    public List<Analysis> getAllAnalysis() {
//    }
}
