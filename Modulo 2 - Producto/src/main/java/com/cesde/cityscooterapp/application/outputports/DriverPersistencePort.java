package com.cesde.cityscooterapp.application.outputports;

import com.cesde.cityscooterapp.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverPersistencePort {


    Driver saveDriver(Driver driver);
    Driver updateDriver(Driver driver);
    Optional<Driver> findDriverById(int id);
    List<Driver> findAllDrivers();
    void deleteDriverById(int id);





}
