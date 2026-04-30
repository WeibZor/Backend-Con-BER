package com.cesde.cityscooterapp.infrastructure.out.adapter;


import com.cesde.cityscooterapp.application.outputports.DriverPersistencePort;
import com.cesde.cityscooterapp.domain.Driver;
import com.cesde.cityscooterapp.infrastructure.out.mapper.DriverMapper;
import com.cesde.cityscooterapp.infrastructure.out.reposotiry.DriverRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DriverRepositoryImpl implements DriverPersistencePort {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverRepositoryImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }


    @Override
    public Driver saveDriver(Driver driver) {
        return null;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> findDriverById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> findAllDrivers() {
        return List.of();
    }

    @Override
    public void deleteDriverById(int id) {

    }
}
