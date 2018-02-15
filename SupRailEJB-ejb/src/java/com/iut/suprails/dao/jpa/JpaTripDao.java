package com.iut.suprails.dao.jpa;

import com.iut.suprails.dao.TripDao;
import com.iut.suprails.entity.TrainStation;
import com.iut.suprails.entity.Trip;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTripDao implements TripDao {

    @PersistenceContext
    private EntityManager em;

    
    @Override
    public Trip addTrip(Trip trip) {
        em.persist(trip);
        return trip;
    }

    @Override
    public List<Trip> getAllTrips() {
        return em.createQuery("SELECT t FROM Trip t").getResultList();
    }

    @Override
    public Trip findTripById(Long tripId) {
        return em.find(Trip.class, tripId);
    }

    @Override
    public void removeTrip(Trip trip) {
        em.remove(trip);
    }

    @Override
    public List<Trip> findTripByIdGare(Long arrivalStationId, Long departureStationId, String price) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = criteriaBuilder.createQuery(Trip.class);
        Root<Trip> quer = query.from(Trip.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(arrivalStationId != null) {
                predicates.add(criteriaBuilder.equal(
                        quer.get("arrivalStation").as(TrainStation.class), arrivalStationId
                ));
        }
        if(departureStationId != null) {
                predicates.add(criteriaBuilder.equal(
                        quer.get("departureStation").as(TrainStation.class), departureStationId
                ));
        }
        if(price != null) {
                predicates.add(criteriaBuilder.equal(
                        quer.get("price").as(String.class), price
                ));
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));

        return em.createQuery(query).getResultList();
    }
    
}
