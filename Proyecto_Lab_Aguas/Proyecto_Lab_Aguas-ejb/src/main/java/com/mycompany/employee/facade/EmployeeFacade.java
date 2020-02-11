/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employee.facade;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import com.mycompany.employee.repository.EmployeeRepository;
import com.mycompany.employee.repository.StaffPositionRepository;
import com.mycompany.employee.service.EmployeeService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EmployeeFacade implements EmployeeFacadeLocal {

    @EJB
    private EmployeeService employeeService;
    @EJB
    private StaffPositionRepository staffPositionRepository;
    @EJB
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @Override
    public List<StaffPosition> getStaffPosition(StaffPosition staffPosition){
        return staffPositionRepository.getStaffPosition(staffPosition);
    }

    public List<StaffPosition> getAllStaffPosition() {
        return staffPositionRepository.getAllRolUser();
    }

    @Override
    public List<Employee> getAuthenticatedUser() {
        return employeeService.getAuthenticatedUser();
    }

    @Override
    public List<Employee> getEmployee(Employee employee) {
        return employeeRepository.getUser(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
