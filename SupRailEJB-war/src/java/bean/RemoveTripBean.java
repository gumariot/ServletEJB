/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.iut.suprails.service.TripService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author gumariot
 */
@ManagedBean
public class RemoveTripBean {

    @EJB
    private TripService tripService;

    public String get_removeTrip(String id) {
        Long tripId = Long.valueOf(id);
        tripService.removeTrip(tripId);
        return "/xhtml/listTrips.xhtml";
    }
    
}
