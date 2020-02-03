/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employee.facade;

import com.mycompany.employee.Employee;
import com.mycompany.employee.service.EmployeeService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class EmployeeFacade implements EmployeeFacadeLocal {

    @EJB
    private EmployeeService employeeService;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

}
