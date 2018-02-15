/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.iut.suprails.entity.TrainStation;
import com.iut.suprails.entity.Trip;
import com.iut.suprails.service.TrainStationService;
import com.iut.suprails.service.TripService;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author gumariot
 */
@ManagedBean
@ApplicationScoped
public class AddTripBean {
    
    @EJB
    private TrainStationService trainStationService;
    
    @EJB
    private TripService tripService;
    private List<TrainStation> trainStations;
    
    private Long currenTrainStationsD;
    private Long currenTrainStationsA;
    
    private String priceparam;
    
    public String get_addTrip(){
        trainStations = trainStationService.getAllTrainStations();
        return "/xhtml/addTrip.xhtml";
    }

    public Long getCurrenTrainStationsA() {
        return currenTrainStationsA;
    }
    
    public Long getCurrenTrainStationsD() {
        return currenTrainStationsD;
    }
    
    public Long currenTrainStationsDFilter() {
        return currenTrainStationsA;
    }
    
    public Long currenTrainStationsAFilter() {
        return currenTrainStationsD;
    }


    public void setCurrenTrainStationsD(Long currenTrainStationsD) {
        this.currenTrainStationsD = currenTrainStationsD;
    }

    public void setCurrenTrainStationsA(Long currenTrainStationsA) {
        this.currenTrainStationsA = currenTrainStationsA;
    }

    public String getPriceparam() {
        return priceparam;
    }

    public void setPriceparam(String priceparam) {
        this.priceparam = priceparam;
    }

    public List<TrainStation> getTrainStations() {
        return trainStations;
    }
    
    

    public String post_addTrip(){
        Long departureId = currenTrainStationsD;
        Long arrivalId = currenTrainStationsA;
        BigDecimal price = new BigDecimal(priceparam);
        
        TrainStation departureStation = trainStationService.findTrainStationById(departureId);
        TrainStation arrivalStation = trainStationService.findTrainStationById(arrivalId);
        
        Trip trip = new Trip(departureStation, arrivalStation, price);
        
        tripService.addTrip(trip);
        
        return "/xhtml/listTrips.xhtml";
    }    
}
