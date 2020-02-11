/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.parameter;

import com.mycompany.packageLab.Parameter;
import com.mycompany.packageLab.facade.PackageLabFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named
@ViewScoped
public class ParameterView implements Serializable{
   
    private List<Parameter> parameterList;
    //private Parameter parameter;
    
    @EJB
    private PackageLabFacadeLocal packageLabFacadeLocal;
    
    @PostConstruct
    public void init() {
        parameterList = packageLabFacadeLocal.AllParameter();
    }

//    public void NewParameter(){
//        packageLabFacadeLocal.CreateParameter(parameter);
//    }
    
    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

//    public Parameter getParameter() {
//        if(parameter == null){
//            parameter = new Parameter();
//        }
//        
//        return parameter;
//    }
//
//    public void setParameter(Parameter parameter) {
//        this.parameter = parameter;
//    }
    
    
}
