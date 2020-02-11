package com.mycompany.employee.service;

import static com.mycompany.config.Constants.PERSISTENCE_UNIT_NAME;
import com.mycompany.employee.Employee;
import com.mycompany.employee.repository.EmployeeRepository;
import java.util.HashMap;
import java.util.List;
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
    
    public Employee createEmployee(Employee employee){
        employee.setPassword(encryptPass(employee.getPassword()));
        entityManager.persist(employee);
        return employee;
    }
    
    public Employee updateEmployee(Employee employee) {
        Employee updateEmployee = entityManager.find(Employee.class, employee.getDpiEmployee());
        if (employee.getNameEmployee()!= null) {
            updateEmployee.setNameEmployee(employee.getNameEmployee());
        }
        if (employee.getPhoneEmployee()!= null) {
            updateEmployee.setPhoneEmployee(employee.getPhoneEmployee());
        }
        if (employee.getPassword() != null) {
            updateEmployee.setPassword(employee.getPassword());
        }
        if (employee.getIsActive() != null) {
            updateEmployee.setIsActive(employee.getIsActive());
        }
        if (employee.getStaffPositionId() != null) {
            updateEmployee.setStaffPositionId(employee.getStaffPositionId());
        }

        return updateEmployee;
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
    public List<Employee> getAuthenticatedUser(){
        String dpi = securityContext.getCallerPrincipal().getName();
        return employeeRepository.getUser(new Employee(dpi));
    }
}
