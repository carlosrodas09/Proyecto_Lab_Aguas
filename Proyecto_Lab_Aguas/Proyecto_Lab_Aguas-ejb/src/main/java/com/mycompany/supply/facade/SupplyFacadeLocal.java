/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.supply.facade;

import com.mycompany.supply.Equipment;
import com.mycompany.supply.Provider;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author daniel
 */
@Local
public interface SupplyFacadeLocal {
    
    public  List<Equipment> AllEquipment();
    public List<Provider> AllProvider();
    
}
