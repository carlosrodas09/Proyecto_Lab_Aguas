/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.packageLab.facade;

import com.mycompany.packageLab.Parameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface PackageLabFacadeLocal {
    
    public List<Parameter> AllParameter();
    //public void CreateParameter(Parameter parameter);
    
}
