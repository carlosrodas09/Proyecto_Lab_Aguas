package gt.edu.usac.cunoc.ingenieria.employee.converter;

import com.mycompany.employee.StaffPosition;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "staffPositionConverter")
public class staffPositionConverter implements Converter {
    
    @Override
    public StaffPosition getAsObject(FacesContext context, UIComponent component, String staffPositionId) {
        try {
            //StaffPosition rolUser=userFacade.getRolUser(new StaffPosition(Integer.parseInt(staffPositionId), null)).get(0);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object rolUser) {
        return ((StaffPosition) rolUser).getIdStaffPosition().toString();
    }

}
