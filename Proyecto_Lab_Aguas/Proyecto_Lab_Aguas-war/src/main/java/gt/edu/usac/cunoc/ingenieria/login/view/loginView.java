package gt.edu.usac.cunoc.ingenieria.login.view;

import com.mycompany.employee.facade.EmployeeFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@ViewScoped
public class loginView implements Serializable{
    //@EJB
    //private EmployeeFacade employeeFacade;
    
    private String dpi;
    private String password;

    public String getDpi() {
        return dpi;
    }

    public void setDpi(final String dpi) {
        this.dpi = dpi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
    public void login() {
    
    }
    
}
