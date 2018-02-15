/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.iut.suprails.entity.Trip;
import com.iut.suprails.service.TripService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author gumariot
 */
@ManagedBean
public class ListTripsBean {

    @EJB
    private TripService tripService;
        
    private Long currenTrainStationsDFilter;
    private Long currenTrainStationsAFilter;
    
    private String price;
    
    private List<Trip> trips;
    
    public String get_Trips(){
        return "xhtml/listTrips.xhtml";
    }

    public List<Trip> getTrips() {
        filter();
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Long getCurrenTrainStationsDFilter() {
        return currenTrainStationsDFilter;
    }

    public void setCurrenTrainStationsDFilter(Long currenTrainStationsDFilter) {
        this.currenTrainStationsDFilter = currenTrainStationsDFilter;
    }

    public Long getCurrenTrainStationsAFilter() {
        return currenTrainStationsAFilter;
    }

    public void setCurrenTrainStationsAFilter(Long currenTrainStationsAFilter) {
        this.currenTrainStationsAFilter = currenTrainStationsAFilter;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String filter() {
        if(currenTrainStationsAFilter != null){
            trips = tripService.findTripByIdGare(currenTrainStationsAFilter,currenTrainStationsDFilter,price);
        }else{
            trips = tripService.getAllTrips();
        }
        return "/xhtml/listTrips.xhtml";
    }
}
