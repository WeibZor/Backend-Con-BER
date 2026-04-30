package com.cesde.cityscooterapp.domain;

import com.cesde.cityscooterapp.domain.enums.IsPenalizedEnum;
import com.cesde.cityscooterapp.domain.enums.TypeDriverEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver extends User{
     @Enumerated(EnumType.STRING)
     private TypeDriverEnum typeDriver;
     private  Integer points;
     @Enumerated(EnumType.STRING)
     private IsPenalizedEnum isPenalized;


    public Driver() {
         super();
    }

     public Driver(TypeDriverEnum typeDriver, Integer points, IsPenalizedEnum isPenalized) {
          this.typeDriver = typeDriver;
          this.points = points;
          this.isPenalized = isPenalized;
     }


     public TypeDriverEnum getTypeDriver() {
          return typeDriver;
     }

     public void setTypeDriver(TypeDriverEnum typeDriver) {
          this.typeDriver = typeDriver;
     }

     public Integer getPoints() {
          return points;
     }

     public void setPoints(Integer points) {
          this.points = points;
     }

     public IsPenalizedEnum getIsPenalized() {
          return isPenalized;
     }

     public void setIsPenalized(IsPenalizedEnum isPenalized) {
          this.isPenalized = isPenalized;
     }
}
