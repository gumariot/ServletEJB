/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.iut.suprails.entity.TrainStation;
import com.iut.suprails.service.TrainStationService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author gumariot
 */
@ManagedBean
public class AddTrainStationBean {
    
    private String name;
    private String adress;
    private String city;
    
    @EJB
    private TrainStationService trainStationService;
    TrainStation trainStation;
    
    public String get_addStation(){
        return "/xhtml/addTrainStation.xhtml";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
     
    
    public String post_addStation(){
        trainStation = new TrainStation();
        trainStation.setAddress(adress);
        trainStation.setCity(city);
        trainStation.setName(name);
        trainStationService.addTrainStation(trainStation);
        return "/xhtml/listTrainStation.xhtml";
    }    
}
