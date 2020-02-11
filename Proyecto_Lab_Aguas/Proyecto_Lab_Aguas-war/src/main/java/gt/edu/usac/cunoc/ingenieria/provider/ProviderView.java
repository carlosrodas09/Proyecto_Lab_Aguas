/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.provider;

import com.mycompany.supply.Provider;
import com.mycompany.supply.facade.SupplyFacadeLocal;
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
public class ProviderView implements Serializable{
    private List<Provider> providerList;
    
    @EJB
    private SupplyFacadeLocal supplyFacadeLocal;
    
    
    
    @PostConstruct
    public void init() {
        providerList = supplyFacadeLocal.AllProvider();
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }
    
    
    
}
