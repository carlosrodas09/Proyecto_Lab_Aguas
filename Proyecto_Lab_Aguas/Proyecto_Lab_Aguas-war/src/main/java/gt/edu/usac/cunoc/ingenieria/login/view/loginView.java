package gt.edu.usac.cunoc.ingenieria.login.view;

import static com.mycompany.config.Constants.SECRETARIA;
import com.mycompany.employee.Employee;
import com.mycompany.employee.facade.EmployeeFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.utils.MessageUtils;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@ViewScoped
public class loginView implements Serializable {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

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

    public void login() throws IOException {
//        Credential credential = new UsernamePasswordCredential(dpi, new Password(password));
//        AuthenticationStatus status = securityContext.authenticate(
//                getRequest(),
//                getResponse(),
//                AuthenticationParameters.withParams().credential(credential));
//        switch (status) {
//            case SEND_CONTINUE:
//                facesContext.responseComplete();
//                break;
//            case SEND_FAILURE:
//                MessageUtils.addErrorMessage("Usuario no encontrado");
//                break;
//            case SUCCESS:
//                redirectToIndex();
//            case NOT_DONE:
//        }
    }

    private HttpServletRequest getRequest() {
//        return (HttpServletRequest) externalContext.getRequest();
        return null;
    }

    private HttpServletResponse getResponse() {
//        return (HttpServletResponse) externalContext.getResponse();
        return null;
    }

    private void redirectToIndex() throws IOException {
//        Employee currentEmployee = employeeFacade.getAuthenticatedUser().get(0);  
//        switch (currentEmployee.getStaffPositionId().getNameStaffPosition()) {
//            case SECRETARIA:
//                externalContext.redirect(externalContext.getRequestContextPath() + "/templates/template.xhtml");
//                break;
//            default:
//        }
    }

}
