/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.iut.suprails.entity.TrainStation;
import com.iut.suprails.service.TrainStationService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;

/**
 *
 * @author gumariot
 */
@ManagedBean
public class ListTrainStationsBean {

    @EJB
    private TrainStationService trainStationService;
    private List<TrainStation> trainStations;
    
    public String get_trainStations(){
        return "xhtml/listTrainStation.xhtml";
    }

    public List<TrainStation> getTrainStations() {
        trainStations = trainStationService.getAllTrainStations();
        return trainStations;
    }
}
