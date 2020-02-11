/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.supply.facade;

import com.mycompany.supply.Equipment;
import com.mycompany.supply.Provider;
import com.mycompany.supply.repository.EquipmentRepository;
import com.mycompany.supply.repository.ProviderRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless
public class SupplyFacade implements SupplyFacadeLocal {

    private EquipmentRepository equipmentRepository;
    private ProviderRepository providerRepository;

    @EJB
    public void setEquipmentRepository(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
    
    @EJB
    public void setProviderRepository(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }
    
    
    public  List<Equipment> AllEquipment(){
         List<Equipment>  lista= equipmentRepository.searchEquipment(null, null, null);
         return lista;
    }

    public List<Provider> AllProvider(){
        List<Provider>  lista= providerRepository.searchSupply(null, null);
         return lista;
    }
    
    
    
}
