package gt.edu.usac.cunoc.ingenieria.employee.view;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import com.mycompany.employee.facade.EmployeeFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class createEmployeeView implements Serializable{
    
    Employee employee;
    List<StaffPosition> staffPositions;
    
    @EJB
    private EmployeeFacade employeeFacade;
    
    @PostConstruct
    public void init(){
        getAllPositions();
    }
    
    private void getAllPositions(){
        
    }

    public Employee getEmployee() {
        if(employee==null){
            employee=new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<StaffPosition> getStaffPositions() {
        return staffPositions;
    }

    public void setStaffPositions(List<StaffPosition> staffPositions) {
        this.staffPositions = staffPositions;
    }
    
    public void createEmployee(){
    
    }
    
}
