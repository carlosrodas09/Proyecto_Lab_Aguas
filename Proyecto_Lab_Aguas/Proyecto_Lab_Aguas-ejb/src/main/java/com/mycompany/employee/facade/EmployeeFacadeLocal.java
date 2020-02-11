package com.mycompany.employee.facade;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmployeeFacadeLocal {

    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public List<StaffPosition> getStaffPosition(StaffPosition staffPosition);
    public List<StaffPosition> getAllStaffPosition();
    public List<Employee> getAuthenticatedUser();
}
