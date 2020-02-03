package com.mycompany.employee.facade;

import com.mycompany.employee.Employee;
import javax.ejb.Local;

@Local
public interface EmployeeFacadeLocal {

    public Employee createEmployee(Employee employee);
    
}
