package com.mycompany.employee.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.employee.Employee;
import com.mycompany.employee.repository.EmployeeRepository;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
@LocalBean
public class EmployeeService {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    
    @Resource
    SessionContext securityContext;
    
    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;
    
    @EJB
    EmployeeRepository employeeRepository;
    
    public void setPbkdf2PasswordHash(Pbkdf2PasswordHash pbkdf2PasswordHash) {
        this.pbkdf2PasswordHash = pbkdf2PasswordHash;
    }
    
    public Employee createEmployee(Employee employee){
        employee.setPassword(encryptPass(employee.getPassword()));
        entityManager.persist(employee);
        return employee;
    }
    
    private String encryptPass(String pass) {
        char passwordInput[] = pass.toCharArray();
        Map<String, String> map = new HashMap<>();
        map.put("Pbkdf2PasswordHash.Iterations", "3072");
        map.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA256");
        map.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        pbkdf2PasswordHash.initialize(map);
        return pbkdf2PasswordHash.generate(passwordInput);
    }
}
