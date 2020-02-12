package com.mycompany.sample.service;

import com.mycompany.sample.service.*;
import com.mycompany.sample.service.*;
import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class DepartmentService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
}
