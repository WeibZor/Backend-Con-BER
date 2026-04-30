package com.cesde.cityscooterapp.infrastructure.out.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cesde.cityscooterapp.application.outputports.DriverPersistencePort;
import com.cesde.cityscooterapp.domain.Driver;
import com.cesde.cityscooterapp.infrastructure.out.repositories.DriverRepository;

@Component
public class DriverPersistenceAdapter implements DriverPersistencePort {

    private final DriverRepository driverRepository;

    public DriverPersistenceAdapter(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> findDriverById(int id) {
        return driverRepository.findById(id);
    }

    @Override
    public List<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void deleteDriverById(int id) {
        driverRepository.deleteById(id);
    }
}