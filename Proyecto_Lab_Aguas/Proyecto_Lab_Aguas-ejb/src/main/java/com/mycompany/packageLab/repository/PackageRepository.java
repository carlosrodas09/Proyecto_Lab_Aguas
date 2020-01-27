package com.mycompany.packageLab.repository;

import com.mycompany.packageLab.PackageL;
import com.mycompany.packageLab.Parameter;
import com.mycompany.packageLab.ParameterPackage;
import static config.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class PackageRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PackageL> findPackageById(Integer id) {
        return Optional.of(entityManager.find(PackageL.class, id));
    }

    public List<Parameter> getParametersOfPackage(Integer id) {
        PackageL pack = entityManager.find(PackageL.class, id);
        List<Parameter> parameters = new LinkedList<>();
        List<ParameterPackage> packlist = pack.getParameterPackageList();
        if (packlist != null && !packlist.isEmpty()) {
            for (ParameterPackage packl : packlist) {
                parameters.add(packl.getParameterId());
            }
        }
        return parameters;
    }

    public List<PackageL> getPackages(String name) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PackageL> criteriaQuery = criteriaBuilder.createQuery(PackageL.class);
        Root<PackageL> packR = criteriaQuery.from(PackageL.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.like(packR.get("name_package"), "%" + name + "%"));
        }

        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<PackageL> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
