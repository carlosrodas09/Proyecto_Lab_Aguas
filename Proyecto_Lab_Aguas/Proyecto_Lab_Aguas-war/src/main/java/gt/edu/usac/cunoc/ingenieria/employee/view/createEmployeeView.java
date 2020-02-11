package gt.edu.usac.cunoc.ingenieria.employee.view;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import com.mycompany.employee.facade.EmployeeFacade;
import com.mycompany.employee.facade.EmployeeFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class createEmployeeView implements Serializable {

    Employee employee;
    List<StaffPosition> staffPositions;

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @PostConstruct
    public void init() {
        getAllPositions();
        getEmployee().setIsActive(true); 
    }
    
    public StaffPosition getStaffPosition(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (StaffPosition staffPosition : staffPositions){
            if (id.equals(staffPosition.getIdStaffPosition())){
                return staffPosition;
            }
        }
        return null;
    }

    private void getAllPositions() {
        this.staffPositions = employeeFacade.getAllStaffPosition();
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
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

    public void createEmployee() {
        employeeFacade.createEmployee(employee);
        cleanUser();
        MessageUtils.addSuccessMessage("Se ha creado el usuario");
    }

    private void cleanUser() {
        employee = null;
    }

}
