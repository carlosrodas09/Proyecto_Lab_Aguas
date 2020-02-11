package gt.edu.usac.cunoc.ingenieria.employee.converter;

import com.mycompany.employee.StaffPosition;
import com.mycompany.employee.facade.EmployeeFacade;
import com.mycompany.employee.facade.EmployeeFacadeLocal;
import gt.edu.usac.cunoc.ingenieria.employee.view.createEmployeeView;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "staffPositionConverter")
public class staffPositionConverter implements Converter {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @Override
    public StaffPosition getAsObject(FacesContext context, UIComponent component, String staffPositionId) {
        ValueExpression vex=context.getApplication().getExpressionFactory()
                        .createValueExpression(context.getELContext(),
                                "#{createEmployeeView}", createEmployeeView.class);
        createEmployeeView createEmployee = (createEmployeeView)vex.getValue(context.getELContext());
        return createEmployee.getStaffPosition(Integer.valueOf(staffPositionId));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object staffPosition) {
        return ((StaffPosition) staffPosition).getIdStaffPosition().toString();
    }

}
