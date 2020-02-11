/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packageLab.facade;

import com.mycompany.packageLab.Parameter;
import com.mycompany.packageLab.repository.parameterRepository;
import com.mycompany.packageLab.service.ParameterService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class PackageLabFacade implements PackageLabFacadeLocal {

    private parameterRepository repository;
    //private ParameterService parameterService;

    @EJB
    public void setRepository(parameterRepository repository) {
        this.repository = repository;
    }

//    @EJB
//    public void setParameterService(ParameterService parameterService) {
//        this.parameterService = parameterService;
//    }

    public List<Parameter> AllParameter() {
        List<Parameter> lista = repository.getParameters(null, null);
        return lista;
    }

//    public void CreateParameter(Parameter parameter) {
//        parameterService.creaParameter(parameter);
//    }

}
