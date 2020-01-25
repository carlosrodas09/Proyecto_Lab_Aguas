package gt.edu.usac.cunoc.ingenieria.user.view;

import com.mycompany.employee.Employee;
import com.mycompany.employee.StaffPosition;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class createEmployeeView {
    Employee employee;
    List<StaffPosition> staffPositions;
    
    @PostConstruct
    public void init(){
        getAllPositions();
    }
    
    private void getAllPositions(){
        
    }
}
