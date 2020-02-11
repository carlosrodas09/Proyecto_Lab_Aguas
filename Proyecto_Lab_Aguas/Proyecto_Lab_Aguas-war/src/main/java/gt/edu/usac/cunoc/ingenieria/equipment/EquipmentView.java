/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.equipment;

import com.mycompany.supply.Equipment;
import com.mycompany.supply.facade.SupplyFacadeLocal;
import com.mycompany.supply.repository.EquipmentRepository;
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
public class EquipmentView implements Serializable{
    
    private List<Equipment> equipmentList;
    
    @EJB
    private SupplyFacadeLocal supplyFacadeLocal;
    
    @PostConstruct
    public void init() {
        equipmentList = supplyFacadeLocal.AllEquipment();
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
    
    
    
    
    
    
}
