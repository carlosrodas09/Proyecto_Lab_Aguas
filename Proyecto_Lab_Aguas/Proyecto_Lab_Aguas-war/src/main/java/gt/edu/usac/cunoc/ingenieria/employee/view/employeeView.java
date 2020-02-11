package gt.edu.usac.cunoc.ingenieria.employee.view;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import com.mycompany.employee.facade.EmployeeFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class employeeView implements Serializable {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    List<Employee> employees = new ArrayList<>();
    List<StaffPosition> staffPositions = new ArrayList<>();
    Employee currentEmployee = new Employee();
    
    private String dpiSearchCriteria;
    private String nameSearchCriteria;

    @PostConstruct
    public void init() {
        getStaffPositions();
    }

    public List<StaffPosition> getStaffPositionEmployees() {
        return this.staffPositions;
    }

    public void setStaffPositionEmployees(List<StaffPosition> staffPositions) {
        this.staffPositions = staffPositions;
    }

    private void getStaffPositions() {
        staffPositions = employeeFacade.getAllStaffPosition();
    }

    public EmployeeFacadeLocal getUserFacade() {
        return employeeFacade;
    }

    public void setUserFacade(EmployeeFacadeLocal empoloyeeFacade) {
        this.employeeFacade = empoloyeeFacade;
    }

    public Employee getCurrentUser() {
        if (currentEmployee == null) {
            currentEmployee = new Employee();
        }
        return currentEmployee;
    }

    public void setCurrentUser(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDpiSearchCriteria() {
        return dpiSearchCriteria;
    }

    public void setDpiSearchCriteria(String dpiSearchCriteria) {
        this.dpiSearchCriteria = dpiSearchCriteria;
    }

    public String getNameSearchCriteria() {
        return nameSearchCriteria;
    }

    public void setNameSearchCriteria(String nameSearchCriteria) {
        this.nameSearchCriteria = nameSearchCriteria;
    }

    public void searchUsers(){
        Employee employee = new Employee();
        if (!getNameSearchCriteria().isEmpty()) {
            employee.setNameEmployee(getNameSearchCriteria());
        }
        if (!getDpiSearchCriteria().isEmpty()) {
            employee.setDpiEmployee(getDpiSearchCriteria());
        }
        setEmployees(employeeFacade.getEmployee(employee)); 
    }

    public void saveChanges(final String modalIdToClose) {
        if (currentEmployee.getDpiEmployee() != null) {
            employeeFacade.updateEmployee(currentEmployee);
            MessageUtils.addSuccessMessage("Se actualizo el usuario");
        }
        clearCurrentUser();
        PrimeFaces.current().executeScript("PF('" + modalIdToClose + "').hide()");
    }

    public void clearCurrentUser() {
        setCurrentUser(null);
    }

    public void changeUserState(final String dpiEmployee){
        Employee employee = new Employee();
        employee.setDpiEmployee(dpiEmployee);
        employee = employeeFacade.getEmployee(employee).get(0);
        employee.setIsActive(!employee.getIsActive());
        employeeFacade.updateEmployee(employee);
        changeLocalStateUser(dpiEmployee);
        clearCurrentUser();
    }

    public void resetPassword(final String modalIdToClose){
        if (currentEmployee.getDpiEmployee() != null) {
            //employeeFacade.resetPassword(currentEmployee);
            MessageUtils.addSuccessMessage("Se actualizo el usuario");
        }
        clearCurrentUser();
        PrimeFaces.current().executeScript("PF('" + modalIdToClose + "').hide()");
    }

    private void changeLocalStateUser(String dpiEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDpiEmployee() == dpiEmployee) {
                employees.get(i).setIsActive(!employees.get(i).getIsActive());
                break;
            }
        }
    }

    public void cleanCriteria() {
        this.dpiSearchCriteria = "";
        this.nameSearchCriteria = "";
    }
}
