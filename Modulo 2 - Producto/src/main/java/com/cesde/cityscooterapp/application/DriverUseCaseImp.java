package com.cesde.cityscooterapp.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cesde.cityscooterapp.application.inputport.DriverUseCase;
import com.cesde.cityscooterapp.application.outputports.DriverPersistencePort;
import com.cesde.cityscooterapp.domain.Driver;


@Service
public class DriverUseCaseImp implements DriverUseCase {

    private final DriverPersistencePort driverPersistencePort;

    public DriverUseCaseImp(DriverPersistencePort driverPersistencePort) {
        this.driverPersistencePort = driverPersistencePort;
    }



    @Override
    public Driver createrDriver(Driver driver) {

        return driverPersistencePort.saveDriver(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> getDriverById(int id) {
        return driverPersistencePort.findDriverById(id);
    }
}
