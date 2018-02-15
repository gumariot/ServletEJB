package com.iut.suprails.entity;

import com.iut.suprails.entity.TrainStation;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-14T19:13:27")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, BigDecimal> price;
    public static volatile SingularAttribute<Trip, Long> id;
    public static volatile SingularAttribute<Trip, TrainStation> departureStation;
    public static volatile SingularAttribute<Trip, TrainStation> arrivalStation;

}