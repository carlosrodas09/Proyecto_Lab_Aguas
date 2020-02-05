package com.mycompany.packageLab.service;

import com.mycompany.packageLab.PackageL;
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
public class PackageService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PackageL createPackage(PackageL pack) {
        entityManager.persist(pack);
        return pack;
    }

    public PackageL updatePackage(PackageL pack, String name, double cost) {
        if (name != null && !name.isEmpty()) {
            pack.setNamePackage(name);
        }
        if (cost >= 0) {
            pack.setPackageCost(cost);
        }
        return entityManager.merge(pack);
    }
}
