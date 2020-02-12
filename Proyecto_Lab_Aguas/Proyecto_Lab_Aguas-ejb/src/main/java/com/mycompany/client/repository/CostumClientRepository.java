package com.mycompany.client.repository;

import com.mycompany.client.repository.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.client.CostumClient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateless
@LocalBean
public class CostumClientRepository {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public List<CostumClient> getAllCostumClient() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CostumClient> criteriaQuery = criteriaBuilder.createQuery(CostumClient.class);
        Root<CostumClient> rootEntry = criteriaQuery.from(CostumClient.class);
        CriteriaQuery<CostumClient> all = criteriaQuery.select(rootEntry);
        TypedQuery<CostumClient> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    public List<CostumClient> getCostumClient(CostumClient costumClient){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CostumClient> criteriaQuery = criteriaBuilder.createQuery(CostumClient.class);
        Root<CostumClient> position = criteriaQuery.from(CostumClient.class);
        List<Predicate> predicates = new ArrayList<>();
        if (costumClient.getIdCostumCategory() != null) {
            predicates.add(criteriaBuilder.equal(position.get("idCostumClient"), costumClient.getIdCostumCategory()));
        }
        if (costumClient.getNameCostumCategory() != null) {
            predicates.add(criteriaBuilder.like(position.get("nameStaffPosition"), "%" + costumClient.getNameCostumCategory()+ "%"));
        }
        criteriaQuery.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<CostumClient> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
